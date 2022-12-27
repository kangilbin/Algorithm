function solution(elements) {
    const len = elements.length
    const set = new Set();
    for(let i=1; i<=len; i++) {
        elements.forEach((num, j) => {
            let re = (j+i) % len;
            if((j+i)/len > 1) {
                set.add([...elements.slice(0, re), ...elements.slice(j, j+i)].reduce((pv,cv) => pv+cv,0))
            } else {
                set.add(elements.slice(j, j+i).reduce((pv,cv) => pv+cv, 0))
            }
        });
    }
    return set.size;
}
