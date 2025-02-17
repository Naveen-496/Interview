const deepEqual = (obj1, obj2) => {
  if (obj1 === obj2) {
    return true;
  }

  if (
    typeof obj1 !== "object" ||
    typeof obj2 !== "object" ||
    obj1 === null ||
    obj2 === null
  ) {
    return obj1 === obj2;
  }

  const keys1 = Object.keys(obj1);
  const keys2 = Object.keys(obj2);

  if (keys1.length !== keys2.length) {
    return false;
  }

  return keys1.every((key) => deepEqual(obj1[key], obj2[key]));
};

console.log(deepEqual({ a: 1, b: 2 }, { a: 1, b: 2 }));
console.log(deepEqual({ c: 3, d: 5 }, { d: 5, c: 3 }));
console.log(
  deepEqual(
    { a: 1, b: "hi", c: false, d: undefined },
    { a: 1, b: 6, c: true, d: null }
  )
);
