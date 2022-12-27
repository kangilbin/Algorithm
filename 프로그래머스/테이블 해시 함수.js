function solution(data, col, row_begin, row_end) {
    var answer = 0;
    data.sort((a, b) => {
        if(a[col-1] === b[col-1]) {
            return b[0] - a[0]; 
        } else {
            return a[col-1] - b[col-1];
        }
    });
    // data의 행의 길이가 고정이 아니기 때문에 reduce로 반복한다
    data.forEach((arr, i) => {
        if(row_begin-1 <= i && i <= row_end-1) {
            answer ^= arr.reduce((pv, cv) => { return pv + cv%(i+1)}, 0) 
        }
    });
    return answer;
}