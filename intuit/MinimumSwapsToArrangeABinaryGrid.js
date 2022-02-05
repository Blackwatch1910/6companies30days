/**
 * @param {number[][]} grid
 * @return {number}
 */
 var minSwaps = function(grid) {
    const arr = [];
    let count = 0;
    
    for(let row of grid) {
        arr.push(row.lastIndexOf(1));
    }
    
    for(let i = 0; i < arr.length; i++) {
        for(let j = 0; j < arr.length; j++) {
            if(arr[j] != null && arr[j] <= i) {
                arr[j] = null; break;
            } else if(arr[j] != null) count++;
        }
    }
    
    if(arr.every(x => x == null)) return count;
    return -1;
};