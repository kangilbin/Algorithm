function solution(n, left, right) {
    var answer = [];
    var q = 0; // 몫
    var r = 0; // 나머지
    
    /*
     * 1) 2차원 배열의 좌표 x, y 중 큰 값 + 1 이 해당 좌표의 값에 해당한다.
     *  arr[x][y] = Math.max(x+1, y+1)
     *  left ~ right까지의 길이 만큼 반복한다.
     */
    for (var i = left; i <= right; i++) {
        // 2) x좌표를 구하는 공식(몫)
        q = Math.floor(i / n);
        
        // 3) y좌표를 구하는 공식(나머지)
        r = i % n;
        
        // 4) 큰 값이 좌표의 값으로 answer에 push
        answer.push(Math.max(q+1, r+1));
    }
    return answer;
}