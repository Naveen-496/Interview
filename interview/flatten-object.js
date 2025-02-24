function flattenObject(obj, newObj = {}) {
  for (const key of Object.keys(obj)) {
    if (typeof obj[key] === "object") {
      flattenObject(obj[key], newObj);
    } else {
      newObj[key] = obj[key];
    }
  }
  return newObj;
}

function flattenWithKeys(obj) {
  const result = {};
  function flat(obj, parentKey = "") {
    for (const key in obj) {
      const newKey = parentKey ? `${parentKey}.${key}` : `${key}`;
      if (typeof obj[key] === "object" && !Array.isArray(obj[key])) {
        flat(obj[key], newKey);
      } else {
        result[newKey] = obj[key];
      }
    }
  }
  flat(obj);
  return result;
}

function unflattenObject(obj) {
  const result = {};

  for (const [key, value] of Object.entries(obj)) {
    const keys = key.split("."); // Split the dot notation keys
    let current = result;

    keys.forEach((k, index) => {
      if (index === keys.length - 1) {
        current[k] = value; // Assign value at the last key
      } else {
        current[k] = current[k] || {}; // Ensure nested object exists
        current = current[k]; // Move deeper
      }
    });
  }

  return result;
}

console.log(flattenObject({ a: 1, b: { c: 1, d: { f: 1 } } }));
const flatted = flattenWithKeys({ a: 1, b: { c: 2, d: [1, 2, 3] } });
console.log(flatted);
const unFlatted = unflattenObject(flatted);
console.log(unFlatted);
