function greet(greeting, punctuation) {
  console.log(`${greeting}, ${this.name}${punctuation}`);
}

const person = { name: "Suresh" };
greet.call(person, "Hello", "!");
greet.apply(person, ["Hi", "(:"]);
const greetBound = greet.bind(person, "Mimi");

greetBound("^^");
