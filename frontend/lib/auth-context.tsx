"use client";

import { createContext, useContext, useEffect, useMemo, useState } from "react";

type AuthContextValue = {
  isAuthenticated: boolean;
  isReady: boolean;
  signIn: () => void;
  signOut: () => void;
};

const AuthContext = createContext<AuthContextValue | undefined>(undefined);

export function AuthProvider({ children }: { children: React.ReactNode }) {
  const [isAuthenticated, setIsAuthenticated] = useState(false);
  const [isReady, setIsReady] = useState(false);

  useEffect(() => {
    const token = window.localStorage.getItem("fing-auth-token");
    setIsAuthenticated(Boolean(token));
    setIsReady(true);
  }, []);

  const value = useMemo<AuthContextValue>(() => ({
    isAuthenticated,
    isReady,
    signIn: () => {
      window.localStorage.setItem("fing-auth-token", "placeholder-session-token");
      setIsAuthenticated(true);
    },
    signOut: () => {
      window.localStorage.removeItem("fing-auth-token");
      setIsAuthenticated(false);
    }
  }), [isAuthenticated, isReady]);

  return <AuthContext.Provider value={value}>{children}</AuthContext.Provider>;
}

export function useAuth() {
  const context = useContext(AuthContext);
  if (!context) {
    throw new Error("useAuth must be used within AuthProvider");
  }
  return context;
}
