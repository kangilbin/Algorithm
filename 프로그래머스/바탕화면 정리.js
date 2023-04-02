function solution(wallpaper) {

    /* 
       1) 시작점 (lux, luy)은 최솟값을 찾을 경우 이므로 초기 값 Infinity을 준다.
          끝점(rdx, rdy)은 최댓값을 찾을 경우로 초기값 0을 준다.
    */
    var answer = [Infinity, Infinity, 0, 0];

    // 2) 2중 배열로 변환한다.
    wallpaper = wallpaper.map(item => item.split(''));

    for(let i=0; i<wallpaper.length; i++) {
        for(let j=0; j<wallpaper[i].length; j++){
            
            // 3) 파일이 있는 칸(#)일 경우만 확인한다.
            if(wallpaper[i][j] === '#') {

               /* 
                  4) 파일이 있는 칸을 전부 포함해 드래그하라면 시작점(lux, luy)이  
                     기존에 등록된 파일의 위치와 비교해 x좌표 y좌표의 최솟값들로 지정해줘야한다.
                */
                answer[0] = Math.min(answer[0], i);
                answer[1] = Math.min(answer[1], j);

                // 5) 반대로 끝점(rdx, rdy)은 최대값들로 지정해준다. 격자판에 맞게 x, y좌표에 +1을 해준다.
                answer[2] = Math.max(answer[2], i+1);
                answer[3] = Math.max(answer[3], j+1);
            }
        }
    }
    // 6) 결과값을 반환한다.
    return answer
}
