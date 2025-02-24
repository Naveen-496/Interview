import React, { createContext, useContext, useState } from "react";

type Theme = "light" | "dark" | "system";
type ThemeDataType = {
  theme: Theme;
  setTheme: (theme: Theme) => void;
};

const ThemeContext = createContext<ThemeDataType | undefined>(undefined);

export const useTheme = () => {
  return useContext(ThemeContext);
};

export default function ThemeProvider({
  children,
}: {
  children: React.ReactNode;
}) {
  const [theme, themeSet] = useState<Theme>("dark");

  const toggleTheme = (theme: Theme) => {
    themeSet(theme);
  };
  return (
    <ThemeContext.Provider value={{ theme, setTheme: toggleTheme }}>
      {children}
    </ThemeContext.Provider>
  );
}
