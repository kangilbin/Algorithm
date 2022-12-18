function solution(str1, str2) {
    var answer = 0;
    let itrt = 0;
    let uno = 0;
    str1 = str1.toLowerCase().split('');
    str2 = str2.toLowerCase().split('');

    const mapStr1 = createMap(str1);
    const mapStr2 = createMap(str2);

    for (let [key, val] of mapStr1) { 
        if(mapStr2.has(key)) {
           itrt += Math.min(mapStr2.get(key), val);
           uno += Math.max(mapStr2.get(key), val);
        } else {
            uno += val;
        }
    }
    for (let [key, val] of mapStr2) {
        if(!mapStr1.has(key)) uno += val;
    }
    answer = Math.floor(itrt / uno * 65536);    
    
    return  isNaN(answer) ? 65536 : answer;
}
function createMap(arrStr){
    const mapStr = new Map()
    arrStr.forEach((str,i) => {
        if(i+1 < arrStr.length) {
            if((/[a-z]/).test(str) && (/[a-z]/).test(arrStr[i+1])) { 
                str = (str + arrStr[i+1]).toLowerCase();
                return mapStr.has(str) ? mapStr.set(str, mapStr.get(str) + 1) : mapStr.set(str, 1)
            }
        }
    });
    return mapStr;
}