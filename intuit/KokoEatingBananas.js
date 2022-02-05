/**
 * @param {number[]} piles
 * @param {number} h
 * @return {number}
 */
 var minEatingSpeed = function(piles, h) {
    let left, mid, right = Math.max(...piles);
      if (piles.length == h)
         return right;
      left=Math.ceil(Math.min(...piles)/(h/piles.length));
      while (left<right) {
        mid = Math.floor((left+right)/2);
        if(piles.reduce((sum, curr)=> sum + Math.ceil(curr/mid),0)<=h)
          right = mid;
        else
          left = mid+1
      }
      return left;
};