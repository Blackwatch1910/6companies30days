/**
 * @param {number[]} weights
 * @param {number} days
 * @return {number}
 */
 var shipWithinDays = function(weights, days) {
    var canWeShipWithinDays = (shipCapacity) => {
       let daysRequired = 0, totalWeight = 0;
       
       for (const weight of weights) {
           if (totalWeight + weight > shipCapacity) {
               daysRequired++;
               totalWeight = 0;
           }
           totalWeight += weight;
       }

       daysRequired += Math.sign(totalWeight);
       return daysRequired <= days;
   };

   let minShipCapacity = 0, maxShipCapacity = 0;
   
   for (const weight of weights) {
       minShipCapacity = Math.max(minShipCapacity, weight);
       maxShipCapacity += weight;
   }

   while (minShipCapacity < maxShipCapacity) {
       const shipCapacity = (minShipCapacity + maxShipCapacity) >> 1;

       if (canWeShipWithinDays(shipCapacity))
           maxShipCapacity = shipCapacity;
       else minShipCapacity = shipCapacity + 1;
   }

   return minShipCapacity;
};