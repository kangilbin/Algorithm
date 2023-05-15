const [a, b, ...arr] = require("fs").readFileSync("/dev/stdin").toString().trim().split(/\n/);

function solution(a, arr) {
  const answer = [];
  const LStack = a.split("");
  const RStack = [];

  arr.forEach((item) => {
    const [command, val] = item.split(" ");
    if (command === "L" && LStack.length) RStack.push(LStack.pop());
    else if (command === "D" && RStack.length) LStack.push(RStack.pop());
    else if (command === "B") LStack.pop();
    else if (command === "P") LStack.push(val);
  });

  console.log([...LStack, ...RStack.reverse()].join(""));
}
solution(a, arr);
