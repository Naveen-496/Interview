function flattenArray(arr, result = []) {
  for (const item of arr) {
    if (Array.isArray(item)) {
      flattenArray(arr, result);
    } else {
      result.push(item);
    }
  }
}

const result = [1, [2, 3, [4, 5]], [5, 6], [[7]]];
console.log(flattenArray(result));
