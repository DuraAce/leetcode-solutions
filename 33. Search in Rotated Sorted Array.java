class Solution {
    public int search(int[] nums, int target) {
        // edge cases
        int n = nums.length;

        // find k
        int start = 0, end = n - 1;
        int k, mid = 0;
        while (start <= end) {
            mid = start + (end - start) / 2;
            if (mid + 1 <= n - 1 && nums[mid] > nums[mid + 1])
                break;
            if (nums[mid] >= nums[0])
                start = mid + 1;
            else if (nums[mid] < nums[0])
                end = mid - 1;            
        }
        k = mid;
        System.out.println("k = " + k);
        
        // binary search
        if (target == nums[0])
            return 0;
        else if (target > nums[0]) {
            int bsResult = Arrays.binarySearch(nums, 0, k + 1, target);
            return bsResult >= 0 ? bsResult : -1;
        }            
        else if (target < nums[0]) {
            int bsResult = Arrays.binarySearch(nums, k + 1, n, target);
            System.out.println(bsResult);
            return bsResult >= 0? bsResult : -1;
        }
        return -1;
    }
}
