function solution(fees, records) {
    var answer = [];
    // 1) 차량별 입,출 시간을 담을 배열 생성
    let map = new Map();

    // 2) 입출차 내역 만큼 반복한다.
    records.forEach((car) => {

        // 3) 공백 기준으로 자른다.
        car = car.split(' ');

        if(map.has(car[1])) {     
           // 4) 입출차 내역이 있으면, 기존 내역에서 새롭게 내역을 추가한다.  
           map.set(car[1], [... map.get(car[1]), chMinute(car[0])]);
        } else {
           // 6) 입출차 내역이 없다면, 새롭게 추가한다.
            map.set(car[1], [chMinute(car[0])]);
        }
    });

    // 7) 정렬을 위해 이터널 객체로 변경해서 차량 번호 기준 오름차순으로 정렬하고, 다시 Map 객체로 변경한다.
    map = new Map([...map].sort((a, b) => a[0] - b[0]));

    // 8) map을 순회한다.
    for(const [key, val] of map) {
   
        // 9) 총 주차 시간(분)
        let minute = 0;

        // 10) 주차 요금
        let amt = 0;

        // 11) 입출차 내역 만큼 반복한다.
        for(let i=0; i<val.length; i+=2){
      
            if(Boolean(val[i+1])) {
                // 12) 출차 기록이 있으면 주차시간(출차 시간 - 입차 시간)을 더한다.
                minute += (val[i+1] - val[i]);    
            } else {
                // 13) 입차 시간만 있다면 주차시간(1439(23:59 을 분으로 변경) - 입차시간)을 더한다.
                minute += (1439 - val[i]);
            }
        };

        
        if(minute-fees[0] > 0) {
            // 14) 기본 시간보다 오래 주차했으면 요금을 계산한다.    
            amt = fees[1] + Math.ceil((minute-fees[0])/fees[2]) * fees[3];
        } else {
            // 15) 기본 시간보다 오래 주차하지 않았다면 기본 요금만 나온다.
            amt = fees[1];
        }

        // 16) 차량의 주차 요금을 answer에 추가한다.
        answer.push(amt);
    }
    return answer;
}

// 5) 입출차 시간대를 분으로 변경하는 함수
function chMinute(time) {
    time = time.split(':');
    return Number(time[0]) * 60 + Number(time[1]);
}