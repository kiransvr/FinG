# FinG Product Requirements (PRD)

## 1. Purpose

FinG enables field collection teams to manage borrowers, loans, repayment demand, overdue follow-up, and recovery operations from a single platform.

## 2. Objectives and Success Metrics

- Reduce manual reconciliation effort by 50% within 3 months of rollout.
- Improve on-time collection rate by 15% within 2 quarters.
- Achieve > 99% daily sync success for field transactions.
- Keep P95 API read latency under 300 ms for core read operations.

## 3. Personas

- Field Officer: captures collections, follows overdue cases.
- Branch Supervisor: reviews performance, approves exceptions.
- Operations Admin: imports data, resolves cleansing errors.
- Management User: monitors portfolio and recovery KPIs.

## 4. Functional Requirements

### FR-001 Borrower Management
- Create, update, view borrower profiles.
- Search borrowers by ID, phone, name.
- Track borrower lifecycle status (active, closed, blocked).

Acceptance criteria:
- Borrower create API validates required fields and returns unique ID.
- Search returns results in under 2 seconds for 100k records with indexing.

### FR-002 Loan Management
- Create and manage loan accounts linked to borrower.
- Capture principal, tenure, schedule, status.
- Show outstanding principal and due summary.

Acceptance criteria:
- Loan cannot be created without valid borrower.
- Outstanding amount is recalculated after every posted payment.

### FR-003 Demand Generation
- Generate installment demand schedules.
- Support daily and monthly demand views.
- Recompute demand after schedule adjustments.

Acceptance criteria:
- Demand generation is idempotent for same loan and period.
- Re-run does not duplicate demand rows.

### FR-004 Collections and Receipts
- Record cash and digital collections.
- Generate receipt reference and audit trail.
- Support offline capture and later sync (mobile).

Acceptance criteria:
- Duplicate submissions are prevented with idempotency keys.
- Every posted collection has immutable audit metadata.

### FR-005 Overdue and Recovery Tracking
- Auto-classify overdue buckets (DPD-based).
- Create and track follow-up actions.
- Capture recovery outcomes and next action dates.

Acceptance criteria:
- DPD bucket assignment matches rules for all test scenarios.
- Recovery action history is visible chronologically.

### FR-006 Notifications
- Trigger reminders for due and overdue accounts.
- Support SMS and in-app notifications.
- Track delivery and retry status.

Acceptance criteria:
- Notification events are queued asynchronously.
- Failed sends retry per configured policy.

### FR-007 Dashboard and Reports
- Supervisor dashboard for collections, overdue, and agent performance.
- Export reports (CSV) for finance and operations.
- Filter by branch, officer, date range.

Acceptance criteria:
- Dashboard KPIs refresh within agreed SLA.
- Exported report totals match on-screen aggregates.

### FR-008 Data Import and Cleansing
- Bulk import borrower and loan data.
- Validate schema and business rules before commit.
- Show error reports for rejected records.

Acceptance criteria:
- Invalid rows are rejected with row-level error reason.
- Valid rows are committed atomically by import batch.

## 5. Non-Functional Requirements

- NFR-001 Availability: 99.9% API uptime target.
- NFR-002 Performance: P95 read latency < 300 ms for core endpoints.
- NFR-003 Security: OAuth2/JWT, RBAC, encryption in transit.
- NFR-004 Auditability: all financial mutations include actor, time, source.
- NFR-005 Scalability: stateless backend services with horizontal scaling.
- NFR-006 Reliability: retry and dead-letter handling for async jobs.
- NFR-007 Compliance: PII masking and access logging.

## 6. Out of Scope (Phase 1)

- Advanced ML-based delinquency prediction.
- Full accounting/general-ledger integration.
- Multi-country tax and regulatory customization.

## 7. Assumptions and Dependencies

- Core master data is available for pilot branches.
- SMS gateway credentials are provided by business team.
- Deployment environment and CI/CD access are provisioned.
