const [arr] = require("fs")
  .readFileSync("./input.txt")
  .toString()
  .split(/\r\n/);

//const [arr] = require("fs").readFileSync("/dev/stdin").toString().split(/\n/);
function solution(arr) {
  const answer = [];

  for (let i = 0; i < arr.length; i++) {
    answer.push(arr.substring(i));
  }
  console.log(answer.sort().join("\n"));
}
solution(arr);
