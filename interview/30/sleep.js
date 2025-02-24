console.log("Start");

async function sleep(millis) {
  return new Promise((resolve) => setTimeout(resolve, millis));
}

(async () => {
  console.log("Sleeping...");
  await sleep(2000);
  console.log("Sleeping Over...");
})();

console.log("End");
