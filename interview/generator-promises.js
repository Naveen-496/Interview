async function* generateOutput(promiseArr) {
  const results = await Promise.allSettled(promiseArr);

  for (const result of results) {
    if (result.status === "fulfilled") {
      yield result.value;
    } else {
      yield -1;
      return;
    }
  }
}

const promises = [1, 2, 3, 4].map((val) => {
  return new Promise((resolve, reject) => {
    if (val === 3) {
      reject(3);
    } else {
      resolve(val);
    }
  });
});

(async () => {
  for await (const value of generateOutput(promises)) {
    console.log(value);
  }
})();
