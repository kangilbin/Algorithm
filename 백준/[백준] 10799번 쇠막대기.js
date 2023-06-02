const [input] = require("fs")
  .readFileSync("./input.txt")
  .toString()
  .trim()
  .split(/\r\n/);

//const [n, ...arr] = require("fs").readFileSync("/dev/stdin").toString().trim().split(/\n/);
function solution(input) {
  let answer = 0;
  const stack = [];
  let isTrue = false;

  input.split("").forEach((item) => {
    if (item === "(") {
      stack.push(item);
      isTrue = true;
    } else {
      if (isTrue) {
        stack.pop();
        answer += stack.length;
        isTrue = false;
      } else {
        stack.pop();
        answer++;
      }
    }
  });

  console.log(answer);
}
solution(input);
