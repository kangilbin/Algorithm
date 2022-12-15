function solution(numbers) {
    // 1) 0~9 까지의 가중치 2차원 배열로 생성한다.
    dist = distance();
    
    // 6) 최초 위치 left, right를 key 값으로 가중치 넣는다.
    const map = new Map([['46', 0]]);

    // 7) 문자열 만큼 반복한다.
    for(let i=0; i<numbers.length; i++){
        // 8) 이동 가능 가짓수 담은 map을 복사한다.
        let tmp = new Map(map);
        let num = numbers[i];  
        
        // 9) map을 초기화하고 다시 이동 가능 가짓수를 담는다.
        map.clear();
        // 10) 현재 이동 가능한 가짓수(tmp) 만큼 반복
        for (let [key, val] of tmp) {
            // 11) key값을 left, right로 자른다.
            let [left, right] = key.split('');
            
            // 12) 오른쪽 이동 중복을 제거 
            if(map.has(left+num) || map.has(num+left)) {
                let rightKey = map.has(left+num) ? left+num : num+left;
                
                // 13) 중복일 경우 가중치 최소 값을 담는다
                map.set(rightKey, Math.min(map.get(rightKey), val + dist[right][num]));
            } else {
                // 14) 왼쪽 이동
                if(left != num) map.set(left+''+num, val+dist[right][num]);
            }
            // 15) 왼쪽 이동 중복 제거
            if(map.has(num+right) || map.has(right+num)) {
                let leftKey = map.has(num+right) ? num+right : right+num;
                map.set(leftKey, Math.min(leftKey, val + dist[left][num]));
            } else {
                // 16) 오른쪽 이동
                if(right != num) map.set(num+''+right, val+dist[left][num]);   
            }
        }
    }
    // 17) 마지막 이동 가능한 가짓수 중 최소 값 return
    return [...map.entries()].reduce((pv, cv) => pv[1] < cv[1] ? pv : cv)[1];
}


// 2) 가중치 구하는 함수  
function distance() {
	// 3) 0~9까지 2차원 배열을 0 값으로 생성한다.
    const w = Array.from({length: 10}, () => Array(10).fill(0));
    
    // 4) 가중치 값을 구해 하나씩 넣는다.
    for (let i = 0; i < 10; i++) {
        for (let j = 0; j<10; j++) {
            /*  
                1. position(i)로 현재 클릭된 값(i)의 위치(x,y)를 찾는다. 
                - x = pad의 행 이동거리(i의 행 - j의 행)
                - y = pad의 열 이동거리(i의 열 - j의 열)
                
                2. 가중치 계산 
                - i, j가 같으면 움직이지 않는 것으로 가중치 1
                - 대가선 이동 : min(x, y의 최소 값) * 3
                - 직선 이동 : 절대값(max - min) * 2
            */
            let x = Math.abs(position(i)[0] - position(j)[0]);
            let y = Math.abs(position(i)[1] - position(j)[1]);
            let min = Math.min(x, y);
            let max = Math.max(x, y)
            w[j][i] = i===j ? 1 : min*3 + Math.abs(max-min)*2; 
        }
    }
    return w
}
// 5) i or j의 현재 위치 반환
function position(num){
    const pad = [
                ["1", "2", "3"],
                ["4", "5", "6"],
                ["7", "8", "9"],
                ["*", "0", "#"]
            ];
    let p = []
    pad.find((arr, i) => {
        if(arr.includes(num+'')) {
             p = [i, arr.indexOf(num+'')];
        }
    });
    return p;
}