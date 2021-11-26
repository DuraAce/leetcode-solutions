class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        List<List<Integer>> results = new ArrayList<>();
        if (n < 3)
            return results;
        Arrays.sort(nums);
        for (int i = 0; i < n - 1; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            List<List<Integer>> result = twoSum(nums, i + 1, 0 - nums[i]);
            if (result.size() != 0) {
                for (List<Integer> res : result) {
                    results.add(res);
                }
            }
        }
        return results;
    }
    
    public List<List<Integer>> twoSum(int[] nums, int start, int k) {
        int n = nums.length;
        List<List<Integer>> results = new ArrayList<>();
        if (n - start < 2)
            return results;
        int left = start, right = n - 1;
        while (left < right) {
            if (nums[left] + nums[right] == k) {
                List<Integer> result = new ArrayList<>();
                result.add(nums[start - 1]);
                result.add(nums[left]);
                result.add(nums[right]);
                results.add(result);
                while (left < right) {
                    left++;
                    if (nums[left] != nums[left - 1])
                        break;
                };
            } else if (nums[left] + nums[right] < k) {
                left++;
            } else {
                right--;
            }
        }
        return results;
    }
}
