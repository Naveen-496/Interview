import { createContext } from "react";

const initialState = {
  first: "Naveen",
  last: "Reddy",
};

export type UserState = typeof initialState;
const userContext = createContext<UserState>(initialState);

export default userContext;
