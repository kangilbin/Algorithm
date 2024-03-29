function solution(m, n, startX, startY, balls) {
    var answer = [];
    
    balls.forEach(item => {
        const [targetX, targetY] = item;
        let min = Infinity;
        
        if(targetX === startX) {    // 동일한 X좌표에 있는 경우 (좌, 우, 선택적 위/아래 가능)
            min = Math.min(min, (targetX + startX)**2 + Math.abs(targetY - startY)**2);     // 좌측 쿠션
            min = Math.min(min, (m+m-targetX-startX)**2 + Math.abs(targetY - startY)**2);   // 우측 쿠션
            if(startY > targetY){   // 시작공이 목표공 보다 위에 있으면 위 쿠션 가능
                min = Math.min(min, Math.abs(targetX - startX)**2 + (n+n-targetY-startY)**2); 
            } else {                // 반대일 경우 아래 쿠션 가능
                min = Math.min(min, Math.abs(targetX - startX)**2 + (targetY + startY)**2);
            }
        } else if(targetY === startY) { // 동일한 Y좌표에 있는 경우 (위, 아래, 선택적 좌/우 가능)
            
            min = Math.min(min, Math.abs(targetX - startX)**2 + (n+n-targetY-startY)**2);   // 위 쿠션
            min = Math.min(min, Math.abs(targetX - startX)**2 + (targetY + startY)**2);     // 아래 쿠션
            if(startX > targetX) {  // 시작공이 목표공 보다 우측에 있으면 우측 쿠션 가능
                min = Math.min(min, (m+m-targetX-startX)**2 + Math.abs(targetY - startY)**2);
            } else {                // 반대일 경우 좌측 쿠션만 가능
                min = Math.min(min, (targetX + startX)**2 + Math.abs(targetY - startY)**2); 
            }
        } else { 
            
            min = Math.min(min, (targetX + startX)**2 + Math.abs(targetY - startY)**2);     // 좌측 쿠션
            min = Math.min(min, (m+m-targetX-startX)**2 + Math.abs(targetY - startY)**2);   // 우측 쿠션
            min = Math.min(min, Math.abs(targetX - startX)**2 + (n+n-targetY-startY)**2);   // 위 쿠션
            min = Math.min(min, Math.abs(targetX - startX)**2 + (targetY + startY)**2);     // 아래 쿠션
        }
        answer.push(min);
    });
    
    
    return answer;
}