const onceFn = (fn) => {
  let called = false;
  let result;

  return (...args) => {
    if (!called) {
      called = true;
      result = fn(...args);
      return result;
    }
    return undefined;
  };
};

const onceCalled = onceFn((a, b, c) => a + b + c);
console.log(onceCalled(10, 20, 30));
console.log(onceCalled(10, 20, 30));
