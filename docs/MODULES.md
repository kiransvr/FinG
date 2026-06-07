# FinG Module Boundaries

## Core Modules

- Data Import and Cleansing
- Borrower Management
- Loan Management
- Demand Generation
- Overdue and Recovery Tracking
- Notification Engine
- Supervisor Dashboard
- Reports

## Suggested Ownership and Interfaces

- Each module owns its domain model and use-case services.
- Cross-module calls should happen through explicit application services or events.
- Shared kernel should be minimal (IDs, enums, common error contract).
