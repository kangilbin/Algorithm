const [n, ...arr] = require("fs")
  .readFileSync("./input.txt")
  .toString()
  .trim()
  .split(/\r\n/);

//   const [n, ...arr] = require("fs")
//   .readFileSync("/dev/stdin")
//   .toString()
//   .trim()
//   .split(/\n/);

function solution(sentence) {
  const answer = [];

  sentence.forEach((item) => {
    let words = "";

    item.split(" ").forEach((word) => {
      const stack = [];
      // 1) 하나씩 stack에 담는다.
      for (let ch of word) {
        stack.push(ch);
      }
     // 2) 위에서 부터 꺼내 문장을 완성 시킨다.
      words += stack.reverse().join("") + " ";
    });
    answer.push(words);
  });
  console.log(answer.join("\n"));
}
solution(arr);
