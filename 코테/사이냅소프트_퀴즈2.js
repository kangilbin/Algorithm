function solution(amount) {
     const digits = ["", "일", "이", "삼", "사", "오", "육", "칠", "팔", "구"];                                   // 숫자 한글 선언
     const units = ["", "십", "백", "천", "만", "십", "백", "천", "억", "십", "백", "천", "조", "십", "백"];    // 금액 단위 선언
     amount = amount.replace(/,|원/gi, "").split("").reverse();                                               // 배열로 변환 후 뒤집기
     const answer = [];    // 한글로 변환한 결과 담을 배열 선언
     let isTrue = true;     // [만, 억, 조] 단위의 위치가 0일 경우를 대비한 단위 표시 여부

     // 1) units, digits의 자릿수에 매칭 시키기 위해 뒤에서부터 카운트한다.
     for(let i=amount.length-1; i >= 0; i--) {

         // 2) 값이 0이 아닐 경우만,
         if(amount[i] != "0" ) {
 
             // 3) [만, 억, 조]에 포함된 단위일 경우만,
             if(["만", "억", "조"].includes(units[i])) {

                 // 4) 한글 숫자 뒤에 단위를 붙인다.
                 answer.push(digits[amount[i]] + units[i] + " ");
                 // 5) [만, 억, 조] 단위를 표시했기 때문에 다시 표시하지 않기 위해 false
                 isTrue = false;
             } else {

                 // 6) 금액이 1일 경우, 단위만 결과값에 push 한다.
                 if(amount[i] == "1" && i != 0) {
                     answer.push(units[i]);            
                 } else {
                     // 7) 아닐경우, 금액과 단위를 같이 push한다.
                     answer.push(digits[amount[i]] + units[i]);
                 }
                 // 8) 금액이 들어왔기 때문에 [만, 억, 조] 단위 표기가 필요하다 true 설정
                 isTrue = true;
             }   
         } else if(["만", "억", "조"].includes(units[i]) && isTrue) {
         // 9) [만, 억, 조] 단위 값이 0일 경우, 단위만 표시해준다.
              answer.push(units[i] + " ");  
              isTrue = false;
         }
     }
     // 10) 결과 값을 반환한다.
     return answer.join("").trim() + "원";
 }