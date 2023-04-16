function solution(n, m, section) {
    let answer = 0;
    // 1) 벽의 길이(n)에 맡게 배열을 만들고 0으로 초기화한다.
    const arr = Array(n).fill(0);
    
    /*  
       2) 새로 칠해줘야 하는 벽의 구역을 1로 변경해 준다.
          벽은 1번부터지만 인덱스는 0번부터로 인덱스에 맞춰 수정해 준다.
    */
    section.forEach(item => arr[item-1] = 1);
    
    let i=0;
    // 3) 벽칠하기 시작
    while(i < arr.length) {

        // 4) 하나씩 확인하며 칠해야 하는 구역(1일 경우)을 찾는다.
        if(arr[i] === 1) {
 
           // 5) 칠하면 answer를 증가시킨다.
           answer++;
 
            // 6) 한 번 칠하면 롤러의 길이(m) 만큼 칠해진다.
            i+=m;
        } else i++;  // 7) 칠할 필요가 없으면 다음 구역으로 넘어간다.
    }
   
    // 7) 페인트칠한 횟수를 반환한다.
    return answer;
}