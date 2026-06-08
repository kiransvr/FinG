import { AppShell } from "@/components/app-shell";
import { ProtectedRoute } from "@/components/protected-route";

export default function HomePage() {
  return (
    <AppShell>
      <section className="hero">
        <p className="badge">Sprint 1 web foundation</p>
        <h2 className="heroTitle">Field collections cockpit with a guarded route skeleton.</h2>
        <p className="heroText">
          This shell establishes the first protected supervisor workspace for borrower, loan, and recovery features.
          Real auth and business screens will layer onto this structure in later sprint stories.
        </p>
        <div className="heroMeta">
          <span className="badge">Next.js app router</span>
          <span className="badge">Auth placeholder</span>
          <span className="badge">API client abstraction</span>
        </div>
        <ProtectedRoute>
          <div className="guard">
            <h3>Protected dashboard area</h3>
            <p>
              Once authenticated, this zone will host borrower search, due collections, and recovery dashboards.
            </p>
          </div>
        </ProtectedRoute>
      </section>
    </AppShell>
  );
}
