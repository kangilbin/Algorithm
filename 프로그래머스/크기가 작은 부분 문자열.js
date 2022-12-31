function solution(t, p) {
    var answer = 0;

    // 1) p길의 만큼 자르기 위해 변수 선언
    let len = p.length;

    // 2) 문자열 t만큼 반복한다.
    for(let i=0; i<t.length; i++) {
       
        // 3) t를 len(p의 길이) 만큼 자르지 못하게 되면 answer를 return한다.
        if(t.length-i < len) return answer;

        /*
            4) 문자열 t를 i부터 len(p의 길이)만큼 자른 숫자가 
               문자열 p 값보다 작거나 같으면 answer증가(숫자 비교)
        */
        if(t.substring(i, len+i) <= p) answer++;
    }
    return answer;
}