function solution(s) {
    return dfs(s, 0, 0);
};
// 1) 재귀 함수를 통해 마지막 결과 값을 가져온다.
function dfs(s, cnt, len) {
    // 2) s 값이 1이되면 반복 횟수, 0삭제 갯수를 return 한다.
    if(s == 1) return [cnt, len];
    
    // 3) s의 총길
    let afLen = s.length;
    
    // 4) 2진수의 0을 제거
    s = s.replace(/0/gi, '');
    
    // 5) 0을 제거한 2진수의 총 길이
    let bfLen = s.length;
    
    // 6) 제거한 0의 개수
    let zeroCnt = afLen - bfLen;
    
    // 7) 다시 반복 한다.
    return dfs(Number(bfLen).toString(2), ++cnt, len+zeroCnt)
};