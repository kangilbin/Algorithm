function solution(book_time) {
    var answer = 0;
    const rooms = [];

    // 1) 입실 시간으로 오름차순 정렬
    book_time.sort((a, b) => {
        if(a[0].replace(':','') > b[0].replace(':','')) return 1
        else return -1
    });
    
    // 2) 고객 방문
    book_time.forEach(item => {
                               
        /* 
            3) 최초에는 빈방 이므로 퇴실 시간으로 방(rooms)에 담는다.
               minutes() -> 시간을 분으로 변경
        */
        if(rooms.length === 0) rooms.push(minutes(item[1]) + 10);  
        else {
            // 5) 현재 등록된 방들과 시간을 비교한다.
            const size = rooms.length;
            for(let i=0; i<size; i++) {
                
                // 6) 방에 등록된 시간 이후에 입실 가능
                if(rooms[i] <= minutes(item[0])) {
                    // 7) 방에 새롭게 현재 고객의 퇴실 시간을 넣어주고 반복문을 빠져나간다.
                    rooms[i] = minutes(item[1]) + 10;
                    break;
                }
                
                // 8) 모든 방을 비교했지만 반복문을 빠져나가지 못했다면 새로운 방을 추가한다.
                if(i === size-1) rooms.push(minutes(item[1]) + 10);
            };
        };        
    });
    
    return rooms.length; 
}

// 4) 시간을 분으로 변경 시켜주는 함수
function minutes(time){
    const [hour, min] = time.split(':');

    return hour * 60 + Number(min);
}
