const [n, arr] = require("fs").readFileSync("/dev/stdin").toString().trim().split(/\n/);
function solution(arr) {
  arr = arr.split(" ");
  const map = new Map();
  arr.forEach((item) => map.set(item, map.has(item) ? map.get(item) + 1 : 1));

  const stack = []; // stack에는 오큰수를 구할 인덱스를 저장한다.
  for (let i = 0; i < arr.length; i++) {
    // 1) stack의 길이가 0이 아니면서, stack의 Top 값이 현재 값보다 작다면(오큰수)
    while (
      stack.length &&
      map.get(arr[stack[stack.length - 1]]) < map.get(arr[i])
    ) {
      // 2) stack의 Top 인덱스를 가져와 값을 찾아
      arr[stack.pop()] = arr[i];
    }
    // 3) stack에는 인덱스를 저장해 오큰수를 구하게되면 값을 찾아갈 수 있게 한다.
    stack.push(i);
  }

  while (stack.length) {
    // 4) 아직 stack에 담겨있는 값이 있다면 오큰수를 찾을수 없는 값들이다.
    arr[stack.pop()] = -1;
  }

  console.log(arr.join(" "));
}
solution(arr);
