function solution(maps) {
    let answer = 1;
    let queue = [];
    const dx = [-1, 1, 0, 0];
    const dy = [0, 0, -1, 1];
    const n = maps.length;
    const m = maps[0].length;
    
    // 시작 위치 담기 
    queue.push([0, 0]);

    // 지나간 위치를 0으로 막는다.(시작 위치도 지나간 위치 이므로 막음ㅈ)
    maps[0][0] = 0;
    
    while(queue.length > 0) {
        let size = queue.length;
        
        for(let i = 0; i < size; i++) {
            let [x, y] = queue.shift();
            
            for(let j = 0; j < 4; j++) {
                let nx = x + dx[j];
                let ny = y + dy[j];
                
                /*
                   nx >= 0 &&  ny >= 0 : 맵을 벗어 나지 않기 위한 조건
                   visited[nx][ny] === 1 : 이동할 위치가 막혀있지 않은지 조건
               */
                if(nx >= 0 && nx < n && ny >= 0 && ny < m && maps[nx][ny] === 1) {
                    // 도착 지점 바로 직전
                    if(nx == n-1 && ny == m - 1) {
                        return answer+1;
                    }
                    queue.push([nx, ny]);
                    maps[nx][ny] = 0;
                }
            }
        }
        answer++;
    }
    
    return -1;
}