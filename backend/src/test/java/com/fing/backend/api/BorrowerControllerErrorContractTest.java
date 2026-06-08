package com.fing.backend.api;

import com.fing.backend.api.controller.BorrowerController;
import com.fing.backend.api.exception.ApiExceptionHandler;
import com.fing.backend.api.exception.CorrelationIdFilter;
import com.fing.backend.application.service.BorrowerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(BorrowerController.class)
@Import({ApiExceptionHandler.class, CorrelationIdFilter.class})
class BorrowerControllerErrorContractTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BorrowerService borrowerService;

    @Test
    void validation_failures_return_stable_error_contract() throws Exception {
        mockMvc.perform(post("/api/v1/borrowers")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"fullName\":\"\",\"phoneNumber\":\"12\"}")
                        .header(CorrelationIdFilter.CORRELATION_ID_HEADER, "test-correlation-id"))
                .andExpect(status().isBadRequest())
                .andExpect(header().string(CorrelationIdFilter.CORRELATION_ID_HEADER, "test-correlation-id"))
                .andExpect(jsonPath("$.status").value(400))
                .andExpect(jsonPath("$.error").value("Bad Request"))
                .andExpect(jsonPath("$.message").value("Validation failed"))
                .andExpect(jsonPath("$.path").value("/api/v1/borrowers"))
                .andExpect(jsonPath("$.correlationId").value("test-correlation-id"))
                .andExpect(jsonPath("$.validationErrors.length()").value(2));
    }

    @Test
    void not_found_errors_return_stable_error_contract() throws Exception {
        UUID borrowerId = UUID.randomUUID();
        when(borrowerService.getBorrower(any(UUID.class)))
                .thenThrow(new IllegalArgumentException("Borrower not found: " + borrowerId));

        mockMvc.perform(get("/api/v1/borrowers/{borrowerId}", borrowerId)
                        .header(CorrelationIdFilter.CORRELATION_ID_HEADER, "lookup-correlation-id"))
                .andExpect(status().isNotFound())
                .andExpect(header().string(CorrelationIdFilter.CORRELATION_ID_HEADER, "lookup-correlation-id"))
                .andExpect(jsonPath("$.status").value(404))
                .andExpect(jsonPath("$.error").value("Not Found"))
                .andExpect(jsonPath("$.message").value("Borrower not found: " + borrowerId))
                .andExpect(jsonPath("$.path").value("/api/v1/borrowers/" + borrowerId))
                .andExpect(jsonPath("$.correlationId").value("lookup-correlation-id"))
                .andExpect(jsonPath("$.validationErrors.length()").value(0));
    }
}