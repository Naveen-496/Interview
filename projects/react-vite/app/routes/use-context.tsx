import { useContext, useState } from "react";
import userContext, { type UserState } from "~/store";

function UserContextConsumerComponent() {
  const user = useContext(userContext);
  return (
    <div>
      {user.first} {user.last}
    </div>
  );
}

export default function UseContextComponent() {
  const [user, setUser] = useState<UserState>({
    first: "Likith",
    last: "Loude",
  });
  return (
    <userContext.Provider value={user}>
      <UserContextConsumerComponent></UserContextConsumerComponent>
    </userContext.Provider>
  );
}
