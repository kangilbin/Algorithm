let answer = [];
function solution(expression) {
    const opts = ["+", "-", "*"];
    let cal = expression.split(/(\D)/);
   
    dfs(opts, cal)
    
    return Math.max(...answer);
};
function dfs(opts, cal){
    if(opts.length === 0) return answer.push(Math.abs(cal));
    
    opts.forEach((opt, i) => {
        dfs([...opts.slice(0, i), ...opts.slice(i+1)], calculation(opt, cal));
    });

    return answer;
}
function calculation(sign, cal){
    if(!cal.includes(sign)) return cal;

    let idx = cal.indexOf(sign);
    let sum = cal[idx-1] + sign + cal[idx+1];
    cal = calculation(sign, [...cal.slice(0, idx-1), eval(sum), ...cal.slice(idx+2)]);

    return cal;
}