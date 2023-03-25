function solution(board) {
    board = board.map(item => item.split(''));
    let O = 0;
    let OTrue = false;
    let X = 0;
    let XTrue = false;
    
    board.forEach((items, i) => {
        items.forEach((item, j) => {
            if(item === 'O') {
                O++;  
                if(check(i, j, board)) OTrue = true;
            } else if(item === 'X') {
                X++;
                if(check(i, j, board)) XTrue = true;
            }
        });
    });
    return check2(O, X, OTrue, XTrue) ? 1 : 0;
}
function check2(o, x, ot, xt) {
    if(o === x) {
        // O의 개수와 X의 개수가 같을 경우 X만 이길 수 있다.
        if(!ot && !xt) return true; // 둘다 빙고를 완성 못하는 경우
        if(!ot && xt) return true;  // X가 빙고일 경우 
    } else if(o === x+1) {
        // O의 개수가 X보다 1개 많다면 O만 이길 수 있다.
        if(!ot && !xt) return true; // 둘다 빙고를 완성 못하는 경우
        if(ot && !xt) return true;  // O가 빙고일 경우
    }
    return false;
}
function check(i, j, board) {
    if(j+2 < board[i].length && i+2 < board.length) {
        if(board[i][j] === board[i+1][j+1] && board[i][j] === board[i+2][j+2]) return true; // '\' 검색
    } 
    if(j+2 < board[i].length) { 
        if(board[i][j] === board[i][j+1] && board[i][j] === board[i][j+2]) return true;      // 우측 검색
    }
    if(i+2 < board.length) {
        if(board[i][j] === board[i+1][j] && board[i][j] === board[i+2][j]) return true;     // 아래 검색
    }
    if(j >= 2 && i+2 < board.length) {
        if(board[i][j] === board[i+1][j-1] && board[i][j] === board[i+2][j-2]) return true; // '/' 검색
    }
    return false;
}