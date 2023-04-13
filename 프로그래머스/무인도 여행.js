function solution(maps) {
    var answer = [];
    const dx = [-1, 1, 0, 0];  // 상하좌우 방향
    const dy = [0, 0, -1, 1];
    maps = maps.map(item => item.split(''));
    const n = maps.length;     // 가로 길이
    const m = maps[0].length;  // 세로 길이
    const q = [];
    
    // 1) 지도의 정보 하나씩 확인
    for(let i=0; i<maps.length; i++) {
        for(let j=0; j<maps[i].length; j++) {
            
            // 2) 바다(X)가 아닐 경우만
            if(maps[i][j] !== 'X') {
                let sum = Number(maps[i][j]); // 식량 담기
                
                // 3) 위치를 q담고 다시 담지 않기 위해 X표시한다.
                q.push([i, j]);
                maps[i][j] = 'X';
                
                // 4) q에 이동할 수 있는 섬의 개수 담고 해당 개수 만큼 반복한다. 
                while(q.length) {
                    
                    // 5) 섬의 좌표 위치에서 이동할 수 있는 섬을 탐색한다. (상하좌우)
                    const [x, y] = q.pop();
                    for(let j=0; j<4; j++) {
                        let nx = x + dx[j];
                        let ny = y + dy[j];
                        
                        // 6) 이동 가능 위치
                        if(nx >= 0 && nx < n && ny >= 0 && ny < m && maps[nx][ny] !== 'X') {
                            // 7) 이동 가능하면 식량을 더하고, X표시 그리고 q에 넣는다.
                            sum += Number(maps[nx][ny]);
                            maps[nx][ny] = 'X';
                            q.push([nx, ny]);
                        }                        
                    }
                }
                
                // 8) 이동 가능한 위치에 있는 섬들의 식량을 answer에 담는다.
                answer.push(sum)
            }
        }
    }
        
    // 9) 무인도에서 지낼수 없으면 -1 있다면 오름차순 정렬한 값을 반환한다.
    return answer.length === 0 ? [-1] : answer.sort((a,b) => a-b);
}