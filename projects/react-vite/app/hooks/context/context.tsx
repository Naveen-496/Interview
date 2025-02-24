// What is the Context API?
// The Context API in React is a built-in state management solution that allows you to share state (data) globally across your component tree without prop drilling.

// 🏆 When to Use?
// When multiple components need access to the same state.
// To avoid prop drilling (passing props deep into components).
// For lightweight global state management.

// 🔹 What is createContext?
// createContext is used to create a global state container in React that allows components to share data without prop drilling.

// 🔹 What is useContext?
// useContext is a hook that allows components to access the data from the Context created using createContext.

// How It Works Internally?
// createContext creates a global storage.
// ThemeProvider provides the state and functions.
// useContext(ThemeContext) allows components to consume the state.
// When toggleTheme() is called, React re-renders all consumers.

import { createContext, useContext, useState, type ReactNode } from "react";

// Define the Theme type
type Theme = "light" | "dark";

// Define the shape of the context data
type ThemeContextType = {
  theme: Theme;
  toggleTheme: () => void;
};

// Create the context
const ThemeContext = createContext<ThemeContextType | undefined>(undefined);

export function ThemeProvider({ children }: { children: ReactNode }) {
  const [theme, setTheme] = useState<Theme>("light");

  const toggleTheme = () => {
    setTheme((prevTheme) => (prevTheme === "light" ? "dark" : "light"));
  };

  return (
    <ThemeContext.Provider value={{ theme, toggleTheme }}>
      {children}
    </ThemeContext.Provider>
  );
}

export function useTheme() {
  const context = useContext(ThemeContext);
  if (!context) {
    throw new Error("useTheme must be used within a ThemeProvider");
  }
  return context;
}
