const [n, ...arr] = require("fs")
  .readFileSync("./input.txt")
  .toString()
  .trim()
  .split(/\r\n/);

/* 제출할 때  */
//   const [n, ...arr] = require("fs")
//   .readFileSync("/dev/stdin")
//   .toString()
//   .trim()
//   .split(/\n/);


function solution(commands) {
  const answer = [];  
  const stack = [];   // 스택 생성

  // 1) 입력 받은 값 만큼 반복한다.
  commands.forEach((item) => {

    const [command, val] = item.split(" ");

    // 2) 명령어에 따라 출려한다.
    switch (command) {
      case "push":
        stack.push(val);
        break;
      case "top":
        answer.push(stack.length ? stack[stack.length - 1] : -1);
        break;
      case "size":
        answer.push(stack.length);
        break;
      case "empty":
        answer.push(stack.length ? 0 : 1);
        break;
      case "pop":
        answer.push(stack.length ? stack.pop() : -1);
        break;
    }
  });
  console.log(answer.join("\n"));
}
solution(arr);
