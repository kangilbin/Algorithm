function solution(keymap, targets) {
    const answer = [];

    // 1) 키의 최솟값을 담을 map 객체 선언
    const map = new Map();
  
    // 2) 각 키의 최솟값을 비교하기 위한 2중 for문
    keymap.forEach((keys) => {
       for(let i=0; i<keys.length; i++) {

           // 3) 기존에 존재한다면 비교후 최솟값 담는다. 없다면, 인덱스 + 1를 저장한다.      
           map.has(keys[i]) ? map.set(keys[i], Math.min(map.get(keys[i]), i+1)) : map.set(keys[i], i+1);
       }
    });

    // 4) 목표(targets) 값을 작성할 수 있는지 판단한다.
    targets.forEach((target) => {
        let sum = 0;
        for(let i=0; i<target.length; i++) {
   
            // 5) 작성 가능 판별
            if(map.has(target[i])) {
                // 6) 가능하면 더한다.
                sum += map.get(target[i]);
            } else {
                // 7) 불가능하면 -1를 저장하고 빠져나간다.
                sum = -1;
                break;
            }
        }
        // 8) 저장된 값을 push한다.
        answer.push(sum)
    });
    return answer;
  }
