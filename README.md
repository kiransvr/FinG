# FinG

FinG is a microfinance field collection and recovery management platform.

## Planned Architecture

- **Architecture Style:** MVC with 3-tier architecture (Presentation, Application, Data)

- **Frontend Web:** Next.js
- **Mobile App:** Flutter
- **Backend API:** Spring Boot
- **Database:** PostgreSQL
- **Cache/Queue:** Redis

## Repository Structure

```text
FinG/
├─ README.md
├─ docs/
│  ├─ ARCHITECTURE.md
│  ├─ REQUIREMENTS.md
│  ├─ PROJECT-PLAN.md
│  ├─ SPRINT-PLAN.md
│  ├─ SPRINT-1-BACKLOG.md
│  ├─ RAID-LOG.md
│  ├─ MODULES.md
│  ├─ DATA-DICTIONARY.md
│  ├─ SETUP.md
│  └─ DECISIONS.md
├─ backend/
├─ frontend/
├─ mobile/
├─ db/
├─ scripts/
└─ sample-data/
```

## Core Modules

- Data import & cleansing
- Borrower management
- Loan management
- Demand generation
- Overdue / recovery tracking
- Notification engine
- Supervisor dashboard
- Reports

## Status

Project planning started.

## Architecture Reference

- See /docs/ARCHITECTURE.md for the MVC 3-tier blueprint and implementation guidance.
- See /docs/REQUIREMENTS.md for functional and non-functional requirements baseline.
- See /docs/PROJECT-PLAN.md for delivery phases, governance, DoR, and DoD.
- See /docs/SPRINT-PLAN.md for sprint-by-sprint outcomes and KPI tracking.
- See /docs/SPRINT-1-BACKLOG.md for detailed Sprint 1 stories, tasks, and acceptance criteria.
- See /docs/RAID-LOG.md for risks, assumptions, issues, and dependencies.
