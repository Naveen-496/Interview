class LazyEvaluater {
  constructor(value) {
    this.value = value;
    this.operations = [];
  }

  add(num) {
    this.operations.push((val) => val + num);
    return this;
  }

  multiply(num) {
    this.operations.push((val) => val * num);
    return this;
  }

  evaluate() {
    return this.operations.reduce((acc, fn) => fn(acc), this.value);
  }
}

const value = new LazyEvaluater(5).add(3).multiply(2).evaluate();
console.log(value);
