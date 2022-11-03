function solution(begin, target, words) {
	// 1) 중복 방지를 위해 변환한 알파벳을 담을 배열 선언
    const visited = [];
    // 2) 큐에 최초 알파벳과 위치를 담는다.
    const queue = [[begin, 0]];

	// 3) 큐에 값이 있으면 반복
    while(queue.length > 0){
    	// 4) 큐에 담긴 최근 값(shift) 가져오기
        let [w, c] = queue.shift();
        // 5) 변환된 알파벳이 타겟과 같으면 종료
        if(w === target) return c;

		// 6) words 배열에 담긴 만큼 반복
        words.forEach(word => {
            // 7) 변환한 알파벳이 다시 같은 값으로 변환하지 않게 비교
            if(!visited.includes(word)){
            	
                // 8) 알파벳 비교 하나만 다른지 체크
                if(checked(w, word)){
                	// 9) 하나만 다르면 해당 word로 변환하고 해당 값과 위치를 큐에 담는다.
                    queue.push([word, ++c]);
                    // 10) 변환된 알파벳을 배열에 담는다.
                    visited.push(word);
                }
            }
        });
    }

    return 0;
}
// 알파벳의 비교 (하나만 다르면 true)
function checked(str1, str2){
    let check = 0;
    for(let i = 0; i < str1.length ; i++){
        if(str1[i] !== str2[i]) check++;
    }
    return check === 1;
}