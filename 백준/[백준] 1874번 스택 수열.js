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

function solution(nums) {
  const answer = [];
  const stack = [0];

  let i = 1;
  for (let j = 0; j < nums.length; j++) {
    // 1) i가 입력값 만큼 같아질 때가지 반복한다.
    while (stack[stack.length - 1] < nums[j]) {
      // 2) stack에 순차적으로 push한다.
      stack.push(i);

      // 3) stack에 push할 경우 결과값에 +
      answer.push("+");
      i++;
    }

    // 4) stack의 마지막 값이랑 입력값이 같은 경우
    if (stack[stack.length - 1] == nums[j]) {

      // 5) stack에서 빼준다.
      stack.pop();

      // 6) stack에 pop할 경우 결과값에 -
      answer.push("-");
    } else {

      // 7) stack의 마지막 값이 입력값이랑 다르다면 수열을 만들수 없다.
      return console.log("NO");
    }
  }
  console.log(answer.join("\n"));
}
solution(arr);
