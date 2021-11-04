/*
prefix sum.  O(n) time, O(n) space
*/
class Solution {
    public int maxSubArray(int[] nums) {
        // prefix array
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        int[] prefix = new int[n + 1];
        prefix[0] = 0;
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }
        
        // search for max
        // get the min till current. max = Math.max(max, prefix[i] - min)
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            min = Math.min(min, prefix[i]);
            max = Math.max(max, prefix[i + 1] - min);
        }
        return max;
    }
}



/*
dp with O(n) time, O(1) space. Kadane's Algorithm
*/
class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int maxSum = nums[0];
        int currentSubarraySum = nums[0];
        for (int i = 1; i < n; i++) {
            currentSubarraySum = Math.max(currentSubarraySum + nums[i], nums[i]);
            maxSum = Math.max(currentSubarraySum, maxSum);
        }
        return maxSum;
    }
}
