# FinG Sprint 1 Backlog (Execution Ready)

## 1. Sprint Goal

Establish production-grade project foundations across backend, web, mobile, data, and DevOps so Sprint 2 can start borrower feature delivery without platform blockers.

## 2. Sprint Window

- Duration: 2 weeks
- Capacity target: 45 story points
- Scope policy: no mid-sprint scope addition without trade-off approval

## 3. Prioritized Story Backlog

| Priority | Story ID | Epic | Story | Points | Owner | Dependency |
|---|---|---|---|---:|---|---|
| P1 | S1-01 | EPIC-01 | Backend layered architecture baseline | 8 | Backend Lead | None |
| P1 | S1-02 | EPIC-01 | PostgreSQL + Flyway migration pipeline | 5 | Backend Engineer | S1-01 |
| P1 | S1-03 | EPIC-01 | Unified API validation and error contract | 5 | Backend Engineer | S1-01 |
| P1 | S1-04 | EPIC-01 | CI quality gate pipeline setup | 8 | DevOps/Backend Lead | S1-01, S1-02 |
| P2 | S1-05 | EPIC-01 | Web shell with auth placeholder and API client base | 5 | Frontend Engineer | S1-04 |
| P2 | S1-06 | EPIC-01 | Mobile shell with auth placeholder and networking base | 5 | Mobile Engineer | S1-04 |
| P2 | S1-07 | EPIC-01 | Observability baseline (health, logs, metrics) | 3 | Backend Engineer | S1-01 |
| P2 | S1-08 | EPIC-01 | QA baseline test strategy and smoke pack | 3 | QA Engineer | S1-03, S1-05, S1-06 |
| P3 | S1-09 | EPIC-01 | Security baseline checklist implementation | 3 | DevSecOps/Backend Lead | S1-04 |

Planned total: 45 points

## 4. Detailed Stories

### S1-01 Backend Layered Architecture Baseline (8 SP)

Description:
Set up enforceable MVC + 3-tier package layout with clear boundaries between API, application, domain, and infrastructure.

Acceptance criteria:
- Project structure exists for api, application, domain, infrastructure layers.
- Dependency direction documented and enforced in code review checklist.
- Health endpoint available and responds with service status.
- Baseline run instructions documented in setup guide.

Tasks:
- Create package conventions and naming standard.
- Add architecture lint rule checklist for PR reviews.
- Add base exception handler and DTO validation path.
- Add health endpoint and basic startup profile config.

Requirement mapping:
- Supports NFR-005, NFR-004.

### S1-02 PostgreSQL and Flyway Migration Pipeline (5 SP)

Description:
Set up relational persistence baseline with migration-first schema management.

Acceptance criteria:
- Datasource config supports env override for URL/user/password.
- Flyway migration auto-runs on startup.
- Initial borrower table migration script exists and is versioned.
- Local DB can run via Docker Compose.

Tasks:
- Add PostgreSQL and JPA dependencies.
- Add migration folder conventions and V1 migration.
- Add db docker compose and startup instructions.
- Validate migration on local startup.

Requirement mapping:
- Supports FR-001, FR-002 foundations and NFR-001.

### S1-03 Unified API Validation and Error Contract (5 SP)

Description:
Standardize request validation and API problem response contract.

Acceptance criteria:
- Bean validation applies to incoming DTOs.
- Validation failures return stable error format.
- Not-found and bad-request handling paths are centralized.
- Error responses include request correlation metadata placeholder.

Tasks:
- Finalize global exception handler.
- Define response schema for validation and business errors.
- Add API examples to documentation.
- Add unit tests for error handler behavior.

Requirement mapping:
- Supports FR-001 acceptance criteria and NFR-004.

### S1-04 CI Quality Gate Pipeline Setup (8 SP)

Description:
Create CI baseline to enforce build quality and security checks before merge.

Acceptance criteria:
- CI runs build, test, and lint checks on pull requests.
- Dependency vulnerability scan report generated in CI.
- Branch protection policy documented.
- Pipeline failure blocks merge in target branch.

Tasks:
- Add pipeline config for backend checks.
- Add lint/static analysis stage.
- Add security scan stage and severity threshold.
- Document PR quality gate policy.

Requirement mapping:
- Supports NFR-003, NFR-006.

### S1-05 Web Shell with Auth Placeholder (5 SP)

Description:
Initialize web app shell with routing, layout, and auth integration placeholder.

Acceptance criteria:
- App boots with base layout and route skeleton.
- Auth guard placeholder wraps protected routes.
- API client module with base URL and interceptors exists.
- Build passes in CI.

Tasks:
- Set up app shell and navigation structure.
- Implement auth context placeholder.
- Add API client abstraction.
- Add simple smoke test for app render.

Requirement mapping:
- Supports future FR-001 to FR-007 delivery.

### S1-06 Mobile Shell with Auth Placeholder (5 SP)

Description:
Initialize Flutter app shell with auth placeholder, environment config, and API client base.

Acceptance criteria:
- App starts with base screen flow and route setup.
- Auth placeholder service exists with token storage abstraction.
- API service abstraction supports environment base URL.
- Build and unit smoke tests pass.

Tasks:
- Initialize mobile app structure and feature folders.
- Add app navigation and placeholder login route.
- Add HTTP client wrapper and config management.
- Add basic widget and service tests.

Requirement mapping:
- Supports FR-004 mobile enablement baseline.

### S1-07 Observability Baseline (3 SP)

Description:
Establish minimum production observability for backend service health and diagnostics.

Acceptance criteria:
- Structured logging format configured.
- Health and info endpoints exposed.
- Metrics endpoint integration planned and documented.

Tasks:
- Add structured log pattern and correlation ID placeholder.
- Validate actuator endpoint exposure.
- Document dashboard starter metrics.

Requirement mapping:
- Supports NFR-001, NFR-002, NFR-006.

### S1-08 QA Baseline Test Strategy and Smoke Pack (3 SP)

Description:
Define and automate minimum test suite required for Sprint 1 deliverables.

Acceptance criteria:
- Smoke checklist for backend/web/mobile is documented.
- API contract smoke tests run in CI.
- Defect triage template prepared.

Tasks:
- Define smoke test cases and pass criteria.
- Add API smoke tests for health and sample endpoints.
- Create defect severity and triage rules.

Requirement mapping:
- Supports quality governance and release readiness.

### S1-09 Security Baseline Checklist (3 SP)

Description:
Apply minimum security controls needed before feature expansion.

Acceptance criteria:
- Secrets policy documented (no plain text secrets in repo).
- Dependency scan baseline completed and tracked.
- Security headers and CORS policy baseline documented.

Tasks:
- Add security checklist to PR template.
- Add secrets handling notes in setup docs.
- Validate baseline dependency scan output.

Requirement mapping:
- Supports NFR-003 and compliance posture.

## 5. Sprint Ceremonies and Control

- Sprint planning output: this backlog is frozen at planning close.
- Daily standup focus: blockers, dependency risks, burn-down variance.
- Mid-sprint review: validate whether P1 scope is at risk.
- End-sprint review: demo against acceptance criteria for each completed story.

## 6. Definition of Done Applied to Sprint 1

A Sprint 1 story is accepted only when:
- Code is merged with peer review.
- Tests are added and passing in CI.
- Documentation is updated for changed behavior.
- Security and logging baseline checks are satisfied.
- Product owner accepts based on listed criteria.

## 7. Stretch Candidates (Only if Capacity Remains)

- ST-01 Add OpenAPI skeleton for borrower APIs.
- ST-02 Add backend integration test with Testcontainers PostgreSQL.
- ST-03 Add lightweight release notes automation.
