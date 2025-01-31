// Fix using let (block scope) or closure
// for (let i = 0; i < 5; i++) {
//   setTimeout(() => console.log(i), 1000 * i);
// }

// Alternative closure fix (pre-ES6):
for (var i = 0; i < 5; i++) {
  (function (j) {
    setTimeout(() => console.log(j), 1000 * j);
  })(i);
  let k = i;
  setTimeout(() => console.log(k), 1000 * k);
}

// Explanation:

// var is function-scoped, so all setTimeout callbacks share the same i (final value 5).

// let creates a new i per iteration
