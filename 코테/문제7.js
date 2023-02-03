function sortByPriceAscending(jsonString) {
    const JData = JSON.parse(jsonString);
    JData.sort((a, b) => {
        if(a.price < b.price) return -1;
        else if(a.price > b.price) return 1;
        else {
            if(a.name < b.name) return -1;
            else if(a.name > b.name) return 1;
            else return 0
        }
    });
    return JSON.stringify(JData);
}

console.log(sortByPriceAscending('[{"name":"eggs","price":1},{"name":"coffee","price":9.99},{"name":"rice","price":4.04}]'));