# Architecture Decision Log

## ADR-001: MVC 3-Tier Architecture

- Status: Accepted
- Date: 2026-06-07

Decision:
Use MVC mapped into a 3-tier architecture (Presentation, Application, Data) for FinG.

Rationale:
- Clear separation of concerns
- Better maintainability as modules grow
- Easier team scaling and ownership boundaries
- Strong fit for web + mobile clients on shared backend APIs

Consequences:
- Requires strict layer boundaries and DTO contracts
- Needs discipline to avoid domain leakage into controllers
