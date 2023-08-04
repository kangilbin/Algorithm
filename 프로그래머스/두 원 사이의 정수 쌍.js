function solution(r1, r2) {
    var answer = 0;
    var r1Y = 0; 
    
    // 1) r2의 길이 만큼 반복문
    for(let i = 1; i < r2; i++) {
        
        // 2) 큰 원(r2)의 경우 Y축 정수의 길이 만큼 점의 개수를 가지기 때문에 소수점을 버린다.
        answer += Math.floor(Math.sqrt(r2**2 - i**2));
        
        // 3) 작은 원(r1)도 동일하게 점의 개수를 구한다.
        if(i < r1) {
            r1Y = Math.sqrt(r1**2 - i**2);
            
            // 4) 작은 원(r1)의 위에 점이 있는 경우
            if(Number.isInteger(r1Y)) {
            
                // 5) 두 점 사이에 있는 점이라고 판단 하므로 r1의 Y축 길이에서 -1
                answer -= r1Y - 1;
            } else {
            
                // 6) 위에 있지 않으면 Y축 정수 길이 만큼 점의 개수를 가진다.
                answer -=  Math.floor(r1Y);
            }
        }
    }
    
    // 7) 1사분면의 점의 개수를 구했으면 4를 곱한다.
    answer *= 4;
    
    // 8) x축, y축 위에 있는 두 원 사이의 점의 개수 더한다.
    answer += (r2 - r1 + 1) * 4;
    
    return answer;
}