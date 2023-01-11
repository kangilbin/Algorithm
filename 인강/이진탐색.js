binarySearch([1,2,3,4,5],2) // 1
binarySearch([1,2,3,4,5],3) // 2
binarySearch([1,2,3,4,5],5) // 4
binarySearch([1,2,3,4,5],6) // -1

function binarySearch(nums, val){
    let idx = -1;
    
    const tree = (nums, idx) => {
        if(nums.length <= 1) return -1;
        
        let left = 0;
        let right = nums.length - 1;
        let mid = Math.ceil((left + right) / 2);

        if(nums[mid] === val) return idx+mid;
        else if (nums[mid] > val) return tree(nums.slice(0, mid + 1), idx)
        else return tree(nums.slice(mid), idx+mid);
    }
    return tree(nums, 0);
}