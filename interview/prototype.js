const animal = {
  type: "Animal",
  jumps: false,
  sleep() {
    console.log("Animal is sleeping");
  },
};

const rabbit = Object.create(animal);
console.log(Object.getPrototypeOf(rabbit) === animal);
rabbit.jumps = true;
rabbit.jump = function () {
  console.log("jumping...");
};

console.log(rabbit.jumps);
rabbit.jump();
rabbit.sleep();

class Person {
  constructor(name) {
    this.name = name;
  }
  getName = function () {
    return this.name;
  };
  setName = (name) => {
    this.name = name;
  };
}

const abhi = new Person("Abhi");
console.log(abhi.getName());
abhi.setName("Abhi Surya");
console.log(abhi.getName());
