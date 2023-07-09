function solution(v) {
    var setX = new Set();
    var setY = new Set();

    v.forEach(([x, y]) => {
        setX.has(x) ? setX.delete(x) : setX.add(x);
        setY.has(y) ? setY.delete(y) : setY.add(y);
    });
    return [...setX, ...setY];
}