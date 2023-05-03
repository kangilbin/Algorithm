const [arr] = require("fs")
  .readFileSync("./input.txt")
  .toString()
  .split(/\r\n/);

//const [n, ...arr] = require("fs").readFileSync("/dev/stdin").toString().trim().split(/\n/);
function solution(arr) {
  const answer = [];
  for (const s of arr) {
    // 1) 유니코드 변경 + 13
    const code = s.charCodeAt() + 13;
    
    if (/[a-z]/.test(s)) {
      if (code > 122) {
        // 2) 122보다 크면 z를 넘은 경우로 다시 a부터 시작
        answer.push(String.fromCharCode(code - 26));
      } else {
        answer.push(String.fromCharCode(code));
      }
    } else if (/[A-Z]/.test(s)) {
      if (code > 90) {
		// 3) 90보다 크면 z를 넘은 경우로 다시 A부터 시작
        answer.push(String.fromCharCode(code - 26));
      } else {
        answer.push(String.fromCharCode(code));
      }
    } else {
      answer.push(s);
    }
  }
  console.log(answer.join(""));
}
solution(arr);