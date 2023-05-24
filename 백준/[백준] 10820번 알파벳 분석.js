var arr = require('fs').readFileSync('/dev/stdin').toString().split('\n');

function solution(arr) {
  const answer = [];
  for(var i in arr){
    // 1) 빈값으로 들어올 경우는 제외
    if(arr[i] === '') continue;
      
    const strArr = [0, 0, 0, 0];
    for (let s of arr[i]) {
      // 2) 조건에 맞게 count
      if (/[a-z]/.test(s)) strArr[0]++;
      else if (/[A-Z]/.test(s)) strArr[1]++;
      else if (/[0-9]/.test(s)) strArr[2]++;
      else strArr[3]++;
    }
    console.log(strArr.join(" "));
  };
}
solution(arr);