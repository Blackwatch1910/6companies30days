
class Solution {

    public int splitArray(int[] nums, int m) {
        
        int start = 0;
        int end = 0;

        for (int i = 0; i < nums.length; i++) {
            start = Math.max (start, nums[i]);
            end = end + nums[i];
        }

        int ans = BinarySearch(start, end, nums, m)

        return ans;
    }
    
    public int BinarySearch (int start, int end, int arr[], int x) {
        while (start < end) {
            int mid = start + (end - start)/2;

            int pieces = 1;
            int sum = 0;

            for (int i: arr) {
                if (sum + i > mid) {
                    sum = i;
                    pieces++;
                }
                else {
                    sum += i;
                }
            }
            if (pieces <= x) {
                end = mid;
            }
            else {
                start = mid + 1;
            }
        }
        return start;
    }
}