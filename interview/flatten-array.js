function flattenArray(arr, result = []) {
  for (const item of arr) {
    if (Array.isArray(item)) {
      flattenArray(item, result);
    } else {
      result.push(item);
    }
  }
  return result;
}

const result = [1, [2, 3, [4, 5]], [5, 6], [[7]]];
console.log(flattenArray(result));
