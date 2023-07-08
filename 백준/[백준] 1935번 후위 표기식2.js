const [n, ...arr] = require("fs")
  .readFileSync("./input.txt")
  .toString()
  .trim()
  .split(/\r\n/);

//const [n, ...arr] = require("fs").readFileSync("/dev/stdin").toString().trim().split(/\n/);
function solution(arr) {
  const stack = [];      // 값을 담을 stack 선언
  const map = new Map(); // 알파벳당 숫자 담을 Map 객체 선언

  let cnt = 1; // 피연산자 위치 
  for (let i = 0; i < arr[0].length; i++) {
    // 1) 알파벳인 경우
    if (/[A-Z]/.test(arr[0][i])) {
      // 2) map에 있는 경우
      if (map.has(arr[0][i])) {

        // 3) 기존 map에 담겨있는 값을 가져와 stack 담는다.
        stack.push(map.get(arr[0][i]));
      } else {

        // 4) map에 없는 경우, map과 stack에 알파벳을 넣는다.
        map.set(arr[0][i], Number(arr[cnt]));
        stack.push(Number(arr[cnt]));
        // 5) 피연산자 위치 증가
        cnt++;
      }
    } else {
      // 6) 알파벳이 아닌 경우 연산자로 이므로 stack 값을 가져와 계산한다.
      const a = stack.pop(), b = stack.pop();
      stack.push(eval(b + arr[0][i] + a));
    }
  }
  // 7) 마지막 남은 stack 값이 최종 계산한 값
  console.log(stack.pop().toFixed(2));
}
solution(arr);
