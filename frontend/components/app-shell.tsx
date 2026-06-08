type AppShellProps = {
  children: React.ReactNode;
};

const navigation = [
  "Borrowers",
  "Loans",
  "Demand",
  "Collections",
  "Recovery",
  "Reports"
];

export function AppShell({ children }: AppShellProps) {
  return (
    <div className="shell" data-testid="app-shell">
      <aside className="sidebar">
        <h1 className="brand">FinG</h1>
        <p className="tagline">
          Sprint 1 web shell for collections, overdue tracking, and supervisor workflows.
        </p>
        <ul className="navList">
          {navigation.map((item) => (
            <li key={item} className="navItem">
              {item}
            </li>
          ))}
        </ul>
      </aside>
      <main className="content">{children}</main>
    </div>
  );
}
