# FinG RAID Log

## Risks

| ID | Type | Description | Probability | Impact | Mitigation | Owner |
|----|------|-------------|-------------|--------|------------|-------|
| R-01 | Risk | Requirements churn during build phase | Medium | High | Freeze sprint scope and run weekly grooming | Product Owner |
| R-02 | Risk | External SMS provider delays integration | Medium | Medium | Use adapter abstraction and sandbox early | Backend Lead |
| R-03 | Risk | Data quality issues in migration files | High | High | Define cleansing rules and dry-run imports | Data Lead |
| R-04 | Risk | Security vulnerabilities near release | Medium | High | Shift-left SAST/DAST and dependency scans | DevSecOps |

## Assumptions

| ID | Type | Statement | Validation Date | Owner |
|----|------|-----------|-----------------|-------|
| A-01 | Assumption | Pilot branches provide sample data on schedule | 2026-06-15 | Business Ops |
| A-02 | Assumption | Team capacity remains stable for first 4 sprints | 2026-06-20 | Engineering Manager |

## Issues

| ID | Type | Description | Severity | Action Plan | Owner | Target Date |
|----|------|-------------|----------|------------|-------|-------------|
| I-01 | Issue | Maven not installed in local environment for build verification | Medium | Install Maven 3.9+ and verify pipelines | Engineering | 2026-06-10 |

## Dependencies

| ID | Type | Dependency | Needed By | Status | Owner |
|----|------|------------|-----------|--------|-------|
| D-01 | Dependency | Production infra and secrets provisioning | Sprint 6 | Open | DevOps |
| D-02 | Dependency | SMS gateway credentials and SLA contract | Sprint 5 | Open | Product Owner |
