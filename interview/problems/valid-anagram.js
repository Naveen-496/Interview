function isValidAnagram(s = "", t = "") {
  if (s.length != t.length) {
    return false;
  }
  return s.split("").sort().join("") === t.split("").sort().join("");
}

function isValidAnagramHashMap(s = "", t = "") {
  const countS = {};
  const countT = {};

  for (let i = 0; i < s.length; i++) {
    countS[s[i]] = (countS[s[i]] || 0) + 1;
    countT[t[i]] = (countT[t[i]] || 0) + 1;
  }
  for (const char of s) {
    if (countS[char] != countT[char]) {
      return false;
    }
  }
  return true;
}

function isValidAnagramsHashTable(s = "", t = "") {
  const count = Array(26).fill(0);

  for (let i = 0; i < s.length; i++) {
    count[s.charCodeAt(i) - "a".charCodeAt(0)]++;
    count[t.charCodeAt(i) - "a".charCodeAt(0)]--;
  }
  console.log(count);
  return count.every((val) => val === 0);
}

console.log(isValidAnagram("animal", "milaan"));
console.log(isValidAnagramHashMap("animal", "milaan"));
console.log(isValidAnagramsHashTable("animal", "malina"));
