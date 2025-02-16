const memoize = (fn) => {
  const map = new Map();

  return (...args) => {
    const key = args.join(",");
    if (map.has(key)) {
      console.log("Returing cached...");
      return map.get(key);
    }
    console.log("Calculating...");
    const result = fn(...args);
    map.set(key, result);
    return result;
  };
};

const fib = (a, b, c) => a + b + (b + c);

const memoized = memoize(fib);
console.log(memoized(1, 2, 3));
console.log(memoized(1, 2, 3));
console.log(memoized(2, 3, 4));
