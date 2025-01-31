async function mapAsync(arr, callback) {
  return Promise.all(arr.map(callback));
}

async function doubleAsync(num) {
  return new Promise((resolve) => setTimeout(() => resolve(num * 2), 1000));
}

async function mapAsyncSequential(arr, callback) {
  const results = [];
  for (const item of arr) {
    results.push(await callback(item));
  }
  return results;
}

mapAsync([1, 2, 3], doubleAsync).then(console.log);
mapAsyncSequential([1, 2, 3], doubleAsync).then(console.log);

// Promise.all to execute all async operations concurrently.

// Explanation:
// 1. why not just use map?
// Ans: 'map' method does not wait for the async operations to complete
//       Instead, it immediately returns an array of Promises, which needs to be resolved.

// 2. why Promise.all ?
// Ans: Promise.all waits for all async operations to complete
//      It returns a single Promise that resolves to an array of results.
//      Promise.all([...]) ensures that all async operations complete before resolving.

// Which One Should You Use?

// Promise.all → For parallel execution (faster, but may overload system).
// for...of with await → For sequential execution (slower, but controlled order).
