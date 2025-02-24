function insertionSort(arr = []) {
  const n = arr.length;
  for (let i = 0; i < n; i++) {
    let key = arr[i]; // item to insert at correct position
    let j = i - 1;

    while (j >= 0 && arr[j] > key) {
      // shift elements if they are greater than the current element
      arr[j + 1] = arr[j];
      j--;
    }
    arr[j + 1] = key;
  }
}
