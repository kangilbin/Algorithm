function solution(sequence) {
    var answer = 0;
    const pSeq = [];
    const mSeq = [];

    // Dynamic Programming 자료구조 방법을 사용하여 최대 값을 구해 저장한다.
    for(let i=0; i<sequence.length; i++) {
        if(i === 0) {
            pSeq.push(sequence[i]);
            mSeq.push(-sequence[i]);
        } else if(i%2 === 0) { // 
            // 처음부터 시작할지 아니면 이어서 최대값을 구할지 정한다.
            pSeq.push(Math.max(pSeq[i-1] + sequence[i], sequence[i]));
            mSeq.push(Math.max(mSeq[i-1] - sequence[i], -sequence[i]));
        } else {
            pSeq.push(Math.max(pSeq[i-1] - sequence[i], -sequence[i]));
            mSeq.push(Math.max(mSeq[i-1] + sequence[i], sequence[i]));
        }
        answer = Math.max(answer, pSeq[i], mSeq[i]);
    }
 
    return answer;
}