/* 
  실행되는 시간이 n의 값이 늘어나는것과 비례하게 1:1비율로, 선형으로 늘어난다.
	시간복잡도 O(n) 
*/
function addFirst(n) {
	var total = 0;
	for (let i=0; i<=n; i++) { 
		total +=i;
	}
	return total
}

/*
   n의 값이 늘어나도 실행 되는 시간에는 아무런 영향을 받지 않는다. 
   시간복잡도 O(1)
*/
function addSec(n) {
	return n * (n + 1 ) / 2;
}

/*
	중첩 루프(for문)을 가진다. O(n) 연산 안에 O(n)을 가지고 있으면 O(n^2)이 된다.
  시간복잡도 O(n^2)
*/
function bigO(n) {
	for (let i=0; i < n; i++) {
		for (let j=0; j < n; j++) {
			console.log(i, j);
		}
	}
}

/*
	입력의 크기에 따라 처리 시간이 증가하는 정렬 알고리즘에 사용 된다.
  시간 복잡도 O(log n)
*/
function bigO(n) {
    for (let i = 2; i <= n; i*2) {
        console.log(i);
    }
}

// 입려시 이미 배열의 길이가 정해져있어 변하는것이 아니기 때문에 공간 복잡도 O(1)를 갖는다.
function sum(arr) {
	let total = 0;
	for (let i=0; i < arr.length; i++) {
		total += arr[i];
	}
}

// arr길이 만큼 newArr의 공간이 생기기 때문에 공간 복잡도 O(n)을 갖는다.
function double(arr) {
	let newArr = [];
	for (let i=0; i < arr.length; i++) {
		newArr.push([i]);
	}
}