const [input] = require("fs").readFileSync("/dev/stdin").toString().trim().split(/\n/);;

function solution(input) {
  const answer = [];
  const [a, b] = input.split(" ");
  const que = Array.from({ length: a }, (v, i) => i + 1);

  let i = 1;
  while (que.length) {
    i % b === 0 ? answer.push(que.shift()) : que.push(que.shift());
    i++;
  }
  console.log("<" + answer.join(", ") + ">");
}
solution(input);
