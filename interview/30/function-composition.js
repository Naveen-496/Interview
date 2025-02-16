const add10 = (x) => x + 10;
const double = (x) => x * 2;

const add10AndDouble = (x) => double(add10(x));
console.log(add10AndDouble(10));

const compose =
  (...fns) =>
  (x) =>
    fns.reduceRight((acc, fn) => fn(acc), x);
/**
 * const composed = (...fns ) => {
 *     return (x) => {
 *    return fns.reduceRight((acc, fn) => fn(acc), x);
 * }
 *
 * }
 *
 *
 *
 */

const composed = compose(add10, double);
console.log(composed(5));
