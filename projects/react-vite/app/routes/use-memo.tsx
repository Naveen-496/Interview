import { useMemo, useState } from "react";

export default function UseMemoComponent() {
  const [numbers, setNumbers] = useState([10, 20, 30]);
  const [count, setCount] = useState(0);

  const total = useMemo(() => {
    setCount((c) => c + 1);
    return numbers.reduce((acc, number) => acc + number, 0);
  }, [numbers]);

  return (
    <div>
      <div>Total : {total}</div>
      <div>Changed: {count}</div>

      <button
        className="px-4 py-2 rounded-lg border border-amber-300"
        onClick={() => {
          if (count % 10 === 0) {
            setNumbers([10, 20, 30]);
            return;
          }
          setNumbers((nums) => [...nums, (nums.length + 1) * 10]);
        }}
      >
        Change
      </button>
    </div>
  );
}
