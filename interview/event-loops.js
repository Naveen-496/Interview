// What is the Event Loop?
// JavaScript is single-threaded, meaning it can execute one task at a time. However, it can handle asynchronous operations using the event loop, which continuously checks and executes tasks in a specific order.

// 🌀 The event loop:

// Executes synchronous code first (in the call stack).
// Processes microtasks (Promises, queueMicrotask, process.nextTick in Node.js).
// Processes macrotasks (setTimeout, setImmediate, I/O, setInterval).
// Repeats (goes back to step 1).

// 2. How Asynchronous Operations Work in the Event Loop?
// 📌 setTimeout (Macro-task)
// setTimeout doesn’t guarantee exact execution time.
// It adds a callback to the macro-task queue after the delay.
// Executes only when the call stack is empty and microtasks are processed.

// 📌 Promises (Micro-task)
// Promise.then callbacks go to the micro-task queue, which runs before the next macro-task.
// Microtasks execute immediately after the synchronous code.

// Execution Order Summary
// Task Type	 Example	                   Queue Type	          Execution Priority
// Synchronous	 Direct function calls	       Call Stack	         🚀 Highest
// Microtasks	 Promise.then	               Micro-task Queue	     🏃‍♂️ Runs before macro-tasks
// Macro-tasks	 setTimeout, I/O, UI Events	   Macro-task Queue	     🕒 Runs after microtasks

// const fs = require("fs");

console.log("Start");

// fs.readFile("test.txt", () => console.log("File Read"));

setTimeout(() => console.log("Timeout"), 0);

Promise.resolve().then(() => console.log("Promise"));

console.log("End");

let searchQuery = "";

function debounce(func, delay) {
  let timer;
  return function (...args) {
    clearTimeout(timer);
    timer = setTimeout(() => func(...args), delay);
  };
}

const search = debounce((query) => {
  console.log(`Searching for: ${query}`);
}, 500);

search("Hello");
search("Hello, World");

// 🚀 The event loop makes JavaScript non-blocking, allowing it to efficiently handle async tasks.
// ✅ Microtasks (Promises) always execute before macro-tasks (setTimeout, I/O).
// ✅ Understanding the event loop is key to writing efficient async code.
