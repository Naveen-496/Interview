const curry = (fn) => {
  return function curried(...args) {
    if (args.length >= fn.length) {
      return fn(...args);
    }

    return (...nextArgs) => {
      return curried(...args, ...nextArgs);
    };
  };
};

const csum = curry((a, b, c) => a + b + c);
console.log(csum(1)(2)(3));
