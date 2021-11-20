class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        if (n == 1) 
            return;
        int swapStart = 0;
        for (int i = n - 1; i > 0; i--) {
            if (nums[i - 1] < nums[i]) {
                findSmallestGreaterThan(nums, i - 1);
                swapStart = i;
                break;
            }
        }
        rotateArray(nums, swapStart, n - 1);       
    }
    
    public void findSmallestGreaterThan(int[] nums, int curr) {
        int index = curr;
        for (int i = curr + 1; i < nums.length; i++) {
            if (nums[i] <= nums[curr]) {
                index = i - 1;
                break;
            }               
        }
        if (index == curr) 
            index = nums.length - 1;
        swap(nums, curr, index);
    }
    
    public void swap(int[] nums, int i, int j)  {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
    
    public void rotateArray(int[] nums, int start, int end) {
        while (start <= end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }
}
