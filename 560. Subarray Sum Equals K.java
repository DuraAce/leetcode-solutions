class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        if (n == 1) {
            return nums[0] == k ? 1 : 0;
        }
        int[] prefix = new int[n];
        Map<Integer, List<Integer>> dict = new HashMap<>();
        dict.put(0, new ArrayList<>(Arrays.asList(-1)));   
        for (int i = 0; i < n; i++) {
            prefix[i] = (i - 1 >= 0 ? prefix[i - 1] : 0) + nums[i];
            dict.putIfAbsent(prefix[i], new ArrayList<>());
            dict.get(prefix[i]).add(i);
            //System.out.println(prefix[i]);
        }
        
        /*
        for (int item : dict.keySet()) {
            System.out.println(item + ",");
        }
        System.out.println();
        */
        
        // prefix[i] - ?? = k
        int resultCnt = 0;
        for (int i = 0; i < n; i++) {
            if (dict.containsKey(prefix[i] - k) ) {
                List<Integer> indexes = dict.get(prefix[i] - k);
                //System.out.println(i);
                for (int index : indexes) {
                    if (index < i)
                        resultCnt++;
                }
            }
        }
        return resultCnt;
    }
}


/*
cleaner solution. Calculate result while build the prefix sum array and map.
*/
class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        if (n == 1) {
            return nums[0] == k ? 1 : 0;
        }
        int cnt = 0;
        int[] prefix = new int[n];
        Map<Integer, Integer> existValue = new HashMap<>();
        existValue.put(0, 1);
        for (int i = 0; i< n; i++) {
            prefix[i] = nums[i] + (i - 1 >= 0 ? prefix[i - 1] : 0);
            // prefix[i] - ?? == k
            if (existValue.containsKey(prefix[i] - k)) {
                cnt += existValue.get(prefix[i] - k);
            } 
            existValue.put(prefix[i], existValue.getOrDefault(prefix[i], 0) + 1);
        }
        return cnt;
    }
}
