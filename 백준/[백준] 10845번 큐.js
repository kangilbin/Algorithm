const [n, ...arr] = require("fs").readFileSync("/dev/stdin").toString().trim().split(/\n/);

function solution(arr) {
  const answer = [];
  const que = [];

  arr.forEach((item) => {
    const [cmd, val] = item.split(" ");
    switch (cmd) {
      case "push":
        que.push(val);
        break;
      case "pop":
        answer.push(que.length ? que.shift() : -1);
        break;
      case "size":
        answer.push(que.length);
        break;
      case "empty":
        answer.push(que.length ? 0 : 1);
        break;
      case "front":
        answer.push(que.length ? que[0] : -1);
        break;
      default:
        answer.push(que.length ? que[que.length - 1] : -1);
        break;
    }
  });
  console.log(answer.join("\n"));
}
solution(arr);
