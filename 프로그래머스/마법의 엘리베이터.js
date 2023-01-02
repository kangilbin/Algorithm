function solution(storey) {
    var answer = 0;
   
    // 1) 엘레베이터가 맨 앞의 숫자가 9를 넘어갈 경우를 대비해 '0'을 추가하여 배열로 담는다.
    storey = ('0'+String(storey)).split('');

    /* 
        2) 엘레베이터 자릿수 만큼 반복한다.
           일의자리 부터 감소하며 반복
    */
    for(let i=storey.length-1; i>=0; i--) {

        // 3) 현재 자릿수의 숫자가 5일 경우     
        if(storey[i] == 5) {
            
            if(storey[i-1] < 5) {
                /*
                     4) 다음 자릿수가 5보다 작다면, 
                        '-' 하는 것이 마법의 돌을 더 적게 사용 된다. 현재 숫자 만큼 마법의돌(answer)을 사용
                */
                answer += Number(storey[i]);
            } else {
                /*
                    5) 다음 자릿수가 5보다 크다면,
                       '+' 하는 것이 마법의 돌을 더 적게 사용 된다. 다음 자릿수를 증가 시킬 만큼 마법의돌 사용
                */
                answer += (10 - Number(storey[i]));
              
                // 6) 다음 자릿수를 증가 시킨다.
                storey[i-1] = Number(storey[i-1]) + 1;
            }
        } else if(storey[i] < 5) {
            // 7) 현재 자릿수가 5보다 작다면, 현재 숫자 만큼 마법의돌(answer)을 사용
            answer += Number(storey[i]);
        } else {
            // 8) 현재 자릿수가 5보다 크다면,  다음 자릿수를 증가 시킬 만큼 마법의돌 사용
            answer += (10 - Number(storey[i]));

            // 6) 다음 자릿수를 증가 시킨다.
            storey[i-1] = Number(storey[i-1]) + 1;
        }
    }
    return answer;
}