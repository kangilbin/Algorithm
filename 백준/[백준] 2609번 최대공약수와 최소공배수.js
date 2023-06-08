const [arr] = require("fs")
  .readFileSync("./input.txt")
  .toString()
  .split(/\r\n/);

//const [arr] = require("fs").readFileSync("/dev/stdin").toString().split(/\n/);
function solution(arr) {
  arr = arr.split(" ");
  const gcd = (a, b) => (a % b === 0 ? b : gcd(b, a % b));
  const min = gcd(arr[0], arr[1]);

  console.log(min);
  console.log(eval(arr[0] * arr[1]) / min);
}
solution(arr);
