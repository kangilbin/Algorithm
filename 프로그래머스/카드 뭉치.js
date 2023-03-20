function solution(cards1, cards2, goal) {
  
    // 1) 원하는 단어를 만들 만큼 반복
    for(let i=0; i<goal.length; i++) {

        if(goal[i] === cards1[0]) {          // 2) cards1에서 사용할 경우      
 	
            // 3) 일치하면 cards1에서 삭제
            cards1.shift();
        } else if(goal[i] === cards2[0]) {  // 4) cards2에서 사용할 경우

            // 5) 일치하면 cards2에서 삭제
            cards2.shift();
        } else {

            // 6) cards1, cards2에 없다면 "No" 반환
            return "No"; 
        };
    };
    
    // 7) 원하는 단어가 만들어지면 "Yes" 반환
    return "Yes";
}