function reverseWordsInAString(str = "") {
  const words = str.split(" ");
  return words.reverse().join(" ");
}

// console.log(reverseWordsInAString("In a nutshell"));

// console.log(Array.isArray([]));
// console.log(Array.isArray(""));
// console.log(Array.isArray({ a: 1 }));

// console.log([1] + 2);

// let arr = [1, 3, 4, 5, 6];
// let arr2 = arr;
// arr = [];
// console.log(arr2);
// console.log(arr);

// arr = arr2;

// arr.length = 0;

// console.log(arr);
// console.log(arr2);

// let arr3 = [1, 3, 4, 5];
// console.log(arr3);
// arr3.splice(0, arr3.length);
// console.log(arr3);

function isInt(num) {
  return num % 1 === 0;
}

console.log(isInt(2.4));
console.log(isInt(4));
console.log(isInt(3));
console.log(isInt(3.4));

console.log(3.4 % 1);
console.log(3 % 1);
