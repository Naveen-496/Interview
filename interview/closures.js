// Definition:
// A closure is a function that "remembers" its lexical scope, even when the function is executed outside that scope. This means it has access to variables from its parent function, even after the parent function has finished executing.

// Closures are possible because of lexical scoping, where functions can access variables defined in their parent scope.

// Lexical Environment & Scope Chain:
// Each function in JavaScript has a lexical environment, which consists of:

// Environment Record – Stores all declared variables and functions in the function’s scope.
// Reference to Outer Lexical Environment – Allows access to variables from the parent function.
// When a function is returned, its lexical environment is preserved, allowing access to outer variables.

function createCounter() {
  let counter = 0;

  return {
    increment: () => ++counter,
    getCount: () => counter,
  };
}

// react hooks example
// Closures are used heavily in React hooks to maintain state in functional components

function useStateExample(initialState) {
  let state = initialState;

  function setState(arg) {
    state = typeof arg === "function" ? arg(state) : arg;
    console.log("Triggering rerender.");
  }

  return [state, setState];
}

// Closures are used extensively in event handlers to retain the state
function createButtonHandler() {
  let clickCount = 0;

  return function () {
    clickCount++;
    console.log(`Button ${clickCount} times.`);
  };
}

const coutner = createCounter();
coutner.increment();
console.log(coutner.getCount());

// Why use closures instead of global variables ?
// If we use global variables, any part of the code can modify it which leads to unexpected behaviour
// Problems with Global Variables:
// ❌ No Encapsulation – Any part of the code can modify count.
// ❌ Pollution of Global Scope – If another script uses count, it may cause conflicts.

// Closures solve this by keeping variables private.


// When Do Closures Exist?
// Closures are NOT just created when a function is returned.
// They exist whenever a function "remembers" variables from its outer scope.
// This happens in:
// Returned functions ✅
// Objects with functions ✅
// setTimeout / setInterval ✅
// Event listeners ✅
// Passing functions as arguments ✅