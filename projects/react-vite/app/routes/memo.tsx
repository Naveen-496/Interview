// 📌 What is React.memo()?
// React.memo() is a higher-order component (HOC) that memoizes a component, meaning it prevents unnecessary re-renders when props haven't changed.

// 🚀 Why Use React.memo()?
// Optimizes performance by preventing unnecessary re-renders.
// Useful for functional components that receive the same props frequently.
// Works well with useCallback() to prevent function re-creation issues.

import React, { useCallback, useState } from "react";

const ChildComponent = React.memo(({ name }: { name: string }) => {
  console.log("Child component re rendered");
  return <div>Name: {name}</div>;
});

export function ParentComponent() {
  const [count, setCount] = useState(0);

  return (
    <div>
      <h1>Count: {count}</h1>
      <ChildComponent name="Alice" />
      <button onClick={() => setCount(count + 1)}>Increment</button>
    </div>
  );
}

export default function MemoParentComponent() {
  const [name, setName] = useState("Alice");
  const [others, setOthers] = useState("");

  const setOthersFn = useCallback(() => {
    setOthers("child two component clicked");
  }, []);

  const setNameFn = useCallback(() => {
    console.log("memo component clicked");
  }, []);

  return (
    <div className="flex flex-col gap-3">
      <ParentComponent />
      <MemoChildOne name={name} />
      <ChildTwoComponent other={others} />
      <button
        onClick={() => setOthers("some")}
        className="px-2 py-1 rounded border border-blue-500"
      >
        Change Others
      </button>
    </div>
  );
}

const MemoChildOne = React.memo(({ name }: { name: string }) => {
  console.log("Child one re rendered ");
  return <div> Name: {name}</div>;
});

const ChildTwoComponent = ({ other }: { other: string }) => {
  console.log("Child two re rendered");

  return <div>Other: {other}</div>;
};
