"use client";

import Link from "next/link";
import { useRouter } from "next/navigation";
import { useState } from "react";
import { useAuth } from "@/lib/auth-context";

export default function SignInPage() {
  const router = useRouter();
  const { signIn } = useAuth();
  const [userId, setUserId] = useState("");

  const handleSubmit = (event: React.FormEvent<HTMLFormElement>) => {
    event.preventDefault();
    signIn();
    router.push("/");
  };

  return (
    <main className="content">
      <section className="signInCard">
        <p className="badge">Placeholder auth flow</p>
        <h1>Sign in to FinG Web</h1>
        <p className="heroText">
          This placeholder route proves the web shell can protect routes before full identity integration.
        </p>
        <form onSubmit={handleSubmit}>
          <label className="field">
            <span>Officer or supervisor ID</span>
            <input
              className="input"
              name="userId"
              value={userId}
              onChange={(event) => setUserId(event.target.value)}
              placeholder="for example: SUP-001"
              required
            />
          </label>
          <div className="actions">
            <button className="button" type="submit">
              Continue
            </button>
            <Link className="secondaryButton" href="/">
              Back to shell
            </Link>
          </div>
        </form>
      </section>
    </main>
  );
}
