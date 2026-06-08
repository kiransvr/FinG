"use client";

import Link from "next/link";
import { useAuth } from "@/lib/auth-context";

type ProtectedRouteProps = {
  children: React.ReactNode;
};

export function ProtectedRoute({ children }: ProtectedRouteProps) {
  const { isAuthenticated, isReady } = useAuth();

  if (!isReady) {
    return <div className="guard">Checking session placeholder...</div>;
  }

  if (!isAuthenticated) {
    return (
      <section className="guard">
        <h2>Auth Placeholder Active</h2>
        <p>
          Protected routes are wired. Sprint 1 uses a placeholder sign-in flow until real identity integration lands.
        </p>
        <div className="actions">
          <Link className="button" href="/sign-in">
            Go to sign in
          </Link>
        </div>
      </section>
    );
  }

  return <>{children}</>;
}
