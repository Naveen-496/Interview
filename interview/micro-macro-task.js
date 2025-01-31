setTimeout(() => console.log("Timeout 1"), 0);
Promise.resolve().then(() => {
  console.log("Promise 1");
  setTimeout(() => console.log("Timeout 2"), 0);
});
queueMicrotask(() => console.log("Microtask")); // adds tasks to micro-task queue manually
console.log("Main");

// Main → Promise 1 → Microtask → Timeout 1 → Timeout 2
