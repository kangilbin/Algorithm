
/*
    지수 정렬
    - 시간 복잡도 O(nk)   n : 정렬할 항목의 수나 정수, k : 이러한 수의 길이(자릿수)
    - 정수만 정렬 가능
*/

// 1) 숫자의 i번째 자릿수 값 가져오는 함수 (ex 324, 2 => 2)
function getDigit(num, i) {
  return Math.floor(Math.abs(num) / Math.pow(10, i)) % 10;
}


// 2) 숫자의 길이를 가져오는 함수 (ex 324 => 3)
function digitCount(num) {
  if (num === 0) return 1;
  return Math.floor(Math.log10(Math.abs(num))) + 1;
}

// 3) 숫자들중 가장 긴 길이를 가져오는 함수 (ex [324, 12, 3345] => 4)
function mostDigits(nums) {
  let maxDigits = 0;
  for (let i = 0; i < nums.length; i++) {
    maxDigits = Math.max(maxDigits, digitCount(nums[i]));
  }
  return maxDigits;
}


// 4) 지수 정렬
function radixSort(nums){
    
    // 5) 가장 긴 길이를 가져온다.
    let maxDigitCount = mostDigits(nums);

    // 6) 길이 만큼 반복
    for(let k = 0; k < maxDigitCount; k++){

        // 7) 0~9 까지 버켓을 생성
        let digitBuckets = Array.from({length: 10}, () => []);

        // 8) 들어있는 숫자 만큼 반복
        for(let i = 0; i < nums.length; i++){

            // 9) 숫자의 k번째 자릿수 값 가져오기
            let digit = getDigit(nums[i],k);

            // 10) 자릿수의 값에 맞는 버켓에 해당 숫자를 담는다
            digitBuckets[digit].push(nums[i]);
        }

        // 11) 하나의 자릿수에 대한 버켓 위치를 마치면, nums 배열의 위치도 동일하게 변경한다.
        nums = [].concat(...digitBuckets);
    }
    return nums;
}

radixSort([23,345,5467,12,2345,9852])








