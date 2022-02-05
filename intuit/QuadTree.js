/**
 * // Definition for a QuadTree node.
 * function Node(val,isLeaf,topLeft,topRight,bottomLeft,bottomRight) {
 *    this.val = val;
 *    this.isLeaf = isLeaf;
 *    this.topLeft = topLeft;
 *    this.topRight = topRight;
 *    this.bottomLeft = bottomLeft;
 *    this.bottomRight = bottomRight;
 * };
 */

/**
 * @param {number[][]} grid
 * @return {Node}
 */
 var construct = function(grid, top=0, bottom=grid.length-1, left=0, right=grid.length-1) {
    let sameValue = true
    
    //check if values are unique or not for the current grid (based on boundaries)
    for (let row=top; row<=bottom; row++) {
        if (!sameValue) break
        for (let col=left; col<=right; col++) {
            if (grid[row][col] !== grid[top][left]) {
                sameValue = false
                break
            }
        }
    }
    
    if (sameValue) {
        return new Node(grid[top][left], true, null, null, null, null)
    } else {
	   //get the mid for vertical and horizontal based on current boundaries, this will help calculate next boundaries
        let vMid = Math.floor((top+bottom)/2)
        let hMid = Math.floor((left+right)/2)
        
        let node = new Node(0, false)
        
        node.topLeft = construct(grid, top, vMid, left, hMid)
        node.topRight = construct(grid, top, vMid, hMid+1, right)
        node.bottomLeft = construct(grid, vMid+1, bottom, left, hMid)
        node.bottomRight = construct(grid, vMid+1, bottom, hMid+1, right)
        
        return node
    } 
};