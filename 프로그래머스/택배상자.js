function solution(order) {
    var answer = 0;
    // 1) 서브 컨테이너 생성 stack 
    const subCtn = [];

    // 2) 기본 컨테이너에 담겨있는 상자 (1부터 순서대로 담겨있기 때문에 최초 상자는 1번)
    let boxIdx = 1;
    
    // 3) 주문 순서대로 반복한다.
    for(let i=0; i<order.length; i++) {
       
        // 4) 서브 컨에티너에 상자를 담고 비교하기 위한 true/false
        let isTrue = true;

        // 5) 서브 컨테이너에 담아 비교하기 위한 반복문
        while(isTrue) {
            
            // 6) 주문 상자가 서브 컨테이너에 담긴 마지막 상자일 경우
            if(order[i] === subCtn.at(-1)) {
                // 7) 맞으면 false를 줘서 반복문을 빠져나간다.
                isTrue = false;

               // 8) 서브 컨테이너에서 꺼낸다.
                subCtn.pop();

                // 9) 트럭에 싣는 상자 증가
                answer++;
            } else {
 
                /* 
	        10) 주문 상자가 번호가 서브 컨테이너에 담긴 상자 번호보다 작으면
                         아무리 서브 컨테이너에 추가해도 상자를 실을 수 없기 때문에 return
                */
                if(order[i] < subCtn.at(-1) ) {
                    return answer;;
                }
                
                // 11) 서브 컨테이너에 상자를 추가한다.
                subCtn.push(boxIdx++);
            }
        }
    };
    return answer;
}