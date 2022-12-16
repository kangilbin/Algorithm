function solution(food) {
    var answer = [0];
    
    for(let i=food.length; i>0; i--) {
        let cnt = Math.floor(food[i] / 2);
        for(let j=0; j<cnt; j++) {
            answer.push(i);
            answer.unshift(i);
        }
    };
    return answer.join('');
}