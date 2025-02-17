console.log("Start");

const promise = new Promise((resolve, reject) => {
  console.log("Inside Promise");
  setTimeout(() => resolve(3), 2000);
  reject(3); // Rejecting instead of resolving
  resolve(2); // This will NOT execute
});

// .then and .catch does not push to the queues immediately, but when the state of the promise
// is changed to fullfilled or rejected, only then the .then is called, which pushes the callback functions to microtask queues
promise
  .then((result) => console.log("Pushed to queue: " + result))
  .catch((error) => console.log("Caught error: " + error));

console.log("Finished");
