function customSetInterval(delay) {
  let time = delay;
  function execute() {
    log(Math.floor(time / 1000));
    time += delay;
    setTimeout(execute, delay);
  }
  execute();
}

const log = (time) => console.log(time);
customSetInterval(1000);
