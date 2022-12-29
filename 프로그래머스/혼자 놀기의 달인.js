let chCards = [];
let cnt = [];
function solution(cards) {
    var answer = 0;
    chCards=cards;
    
    for(let i=0; i<chCards.length; i++) {
        if(chCards[i] !== 0) {
            dfs(chCards[i], []);
        }
    }
    cnt.sort((a,b) => b-a);

    return isNaN(cnt[0] * cnt[1]) ? 0 : cnt[0] * cnt[1];
}
function dfs(card, arr) {
    let idx = chCards[card-1];
    chCards[card-1] = 0;

    if(idx === 0) return cnt.push(arr.length);
    return dfs(idx, [...arr, idx]);
}