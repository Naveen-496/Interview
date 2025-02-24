import { useTheme } from "~/hooks/context/theme-context";

export function Welcome() {
  const theme = useTheme();
  if (!theme) {
    return "";
  }

  return (
    <main className="flex items-center justify-center pt-16 pb-4 dark">
      {theme.theme}

      <button onClick={() => theme.setTheme("light")}>Change Theme</button>
    </main>
  );
}
