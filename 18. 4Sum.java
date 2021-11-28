class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        return kSum(nums, 4, target, 0);
    }
    
    public List<List<Integer>> kSum(int[] nums, int k, int target, int start) {
        List<List<Integer>> results = new ArrayList<>();
        if (k == 2) {
            int left = start, right = nums.length - 1;
            while (left < right) {
                if (nums[left] + nums[right] == target) {
                    List<Integer> result = new ArrayList<>();
                    result.add(nums[left]);
                    result.add(nums[right]);
                    results.add(result);
                    left++;
                    right--;
                    // IMPORTANT!!! De-dup
                    while (left < right && nums[left] == nums[left - 1]) left++;          
                } else if (nums[left] + nums[right] < target) {
                    left++;
                } else {
                    right--;
                }                
            }            
        } else {
            for (int i = start; i <= nums.length - k; i++) {
                List<List<Integer>> result = kSum(nums, k - 1, target - nums[i], i + 1);
                for (int j = 0; j < result.size(); j++) {
                    result.get(j).add(nums[i]);
                    results.add(result.get(j));
                }
                // IMPORTANT!!! De-dup
                while (i <= nums.length - k - 1 && nums[i] == nums[i + 1]) i++;
            }
        }
        return results;
    }
    
    
}
