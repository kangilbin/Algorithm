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

function solution(row) {
  const answer = [];

  row.forEach((item) => {
    const vps = item.split("");

   // 1) stack 생성
    const stack = [];
    let YN = "YES";
    for (let i = 0; i < vps.length; i++) {

      // 2) '('가 들어오면 stack에 쌓는다,
      if (vps[i] === "(") stack.push(vps[i]);

      // 3) ')'가 들어오면 stack에서 뺀다
      else {
        // 4) stack에 담겨있는게 없으면 완성된 괄호를 못 만든다.
        if (!stack.pop()) {  
          // 5) 반복문을 빠져 나간다.
          YN = "NO";
          break;
        }
      }
    }

    // 6) 반복문이 끝났는데 stack에 괄호가 남아있다면 미완성된 괄호들이기 때문에 NO를 저장한다.
    if (!!stack.length) YN = "NO";
    answer.push(YN);
  });
  console.log(answer.join("\n"));
}
solution(arr);
