import { useEffect, useState } from "react";

export default function UseEffectComponent() {
  const [time, setTime] = useState(1);
  useEffect(() => {
    const timer = setInterval(() => {
      // will not work properly as it created closure with the value 1 initially
      //   setTime(time + 1);
      setTime((t) => t + 1);
    }, 1000);

    return () => clearInterval(timer);
  }, []);
  return (
    <main>
      <button className="px-4 py-2 rounded-lg border-amber-300">{time}</button>
    </main>
  );
}
