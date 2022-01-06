class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int answer = Integer.MAX_VALUE;

        int left = 0;
        int curr_sum = 0;

        for (int i = 0; i < nums.length; i++) {
            curr_sum += nums[i];

            while (curr_sum >= target) {
                answer = Math.min(answer, i + 1 - left);
                curr_sum -= nums[left];
                left++;
            }
        }

        return (answer != Integer.MAX_VALUE) ? answer : 0;
    }
}