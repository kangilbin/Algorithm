/*
function reverse(str){
    return str.split('').reverse().join('')
}
*/

// reverse('awesome') // 'emosewa'
// reverse('rithmschool') // 'loohcsmhtir'

function reverse(str){
    if(str.length === 1) return str[0];
    
    
    return reverse(str.substring(1)) + str[0];
}


// isPalindrome('awesome') // false
// isPalindrome('foobar') // false
// isPalindrome('tacocat') // true
// isPalindrome('amanaplanacanalpanama') // true
// isPalindrome('amanaplanacanalpandemonium') // false

function isPalindrome(str){
    if(str.length === 1) return true;
    
    if(str[0] === str[str.length-1]) {
        return isPalindrome(str.substring(1, str.length-1));    
    } else {
        return false;
    }
}

// SAMPLE INPUT / OUTPUT
// const isOdd = val => val % 2 !== 0;

// someRecursive([1,2,3,4], isOdd) // true
// someRecursive([4,6,8,9], isOdd) // true
// someRecursive([4,6,8], isOdd) // false
// someRecursive([4,6,8], val => val > 10); // false

/*
function someRecursive(nums, callback){
    return nums.some(num => callback(num));
}
*/



// flatten([1, 2, 3, [4, 5] ]) // [1, 2, 3, 4, 5]
// flatten([1, [2, [3, 4], [[5]]]]) // [1, 2, 3, 4, 5]
// flatten([[1],[2],[3]]) // [1,2,3]
// flatten([[[[1], [[[2]]], [[[[[[[3]]]]]]]]]]) // [1,2,3]

function someRecursive(nums, callback){
    if(nums.length === 0) return false;
    
    if(callback(nums[0])) return true;
    
    return someRecursive(nums.slice(1), callback);
}

function flatten(arr){
    const answer = [];
    
    function rec(obj) {
        if(obj.length === 0) return;
        
        if(typeof(obj[0]) === 'object') rec(obj[0]);
        else {
            answer.push(obj[0]);
        }
         rec(obj.slice(1));
    }
    rec(arr);
    
    return answer;
}
