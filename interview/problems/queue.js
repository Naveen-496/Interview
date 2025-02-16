const inputStack = [];

function enque(stackInput, ele) {
  return stackInput.push(ele);
}

function deque(stackInput, outputStack) {
  if (outputStack.length <= 0) {
    while (stackInput.length > 0) {
      let elementToPop = stackInput.pop();
      outputStack.push(elementToPop);
    }
  }
  return outputStack.pop();
}
