const [n, arr] = require("fs")
  .readFileSync("./input.txt")
  .toString()
  .split(/\r\n/);

//const [arr] = require("fs").readFileSync("/dev/stdin").toString().split(/\n/);
function solution(arr) {
  const isPrimeNumber = (n) => {
    if (n == 1) return false;
    let end = Math.sqrt(n);

    for (let i = 2; i <= end; i++) {
      if (n % i == 0) return false;
    }
    return true;
  };

  console.log(arr.split(" ").filter((item) => isPrimeNumber(item)).length);
}
solution(arr);
