// power(2,0) // 1
// power(2,2) // 4
// power(2,4) // 16

function power(num, exp){
    if(exp < 1) return 1;
    
    return num * power(num, exp-1);
}

//factorial(1) // 1
// factorial(2) // 2
// factorial(4) // 24
// factorial(7) // 5040

function factorial(num){
    if(num < 2) return 1;
    
    return num * factorial(num-1);
}



// productOfArray([1,2,3]) // 6
// productOfArray([1,2,3,10]) // 60
function productOfArray(nums) {
    let mul = nums[0];
    
    function rec(arr) {
        if(arr.length === 0) return;
        
        mul *= arr[0]
        
        return rec(arr.slice(1));
    }
    rec(nums.slice(1));
    
    return mul;
}


// SAMPLE INPUT/OUTPUT
// recursiveRange(6) // 21
// recursiveRange(10) // 55 

function recursiveRange(num){
   if(num === 1) return 1;
   
   return num + recursiveRange(num-1);
}



// fib(4) // 3
// fib(10) // 55
// fib(28) // 317811
// fib(35) // 9227465

function fib(num){
    const arr = [1,1];
     
    function fibonacci(seq) {
        if(num === seq) return;
        
        let sum = arr[arr.length-1] + arr[arr.length-2];
        arr.push(sum); 
        
        fibonacci(seq+1);
        return;
    }
    fibonacci(2)
    
    return arr.pop();
}