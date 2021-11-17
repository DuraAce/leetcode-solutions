class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, Collections.reverseOrder());
        PriorityQueue<Integer> toBeRemoved = new PriorityQueue<>(k, Collections.reverseOrder());
        for (int i = 0; i < k; i++) {
            maxHeap.offer(nums[i]);
        }
        int n = nums.length;
        if (n == 1)
            return new int[] {nums[0]};
        int[] result = new int[n - k + 1];
        result[0] = maxHeap.peek();        
        
        for (int i = 0; i < n - k; i++) {
            maxHeap.offer(nums[k + i]);
            toBeRemoved.offer(nums[i]);
            //System.out.println(maxHeap.peek() + " " + toBeRemoved.peek());
            while (toBeRemoved.size() != 0)  {
                int a = maxHeap.peek();
                int b = toBeRemoved.peek();
                if (a == b) {
                    //System.out.println("true");
                    maxHeap.poll();
                    toBeRemoved.poll();
                } else 
                    break;
            }
            result[i + 1] = maxHeap.peek();
        }
        return result;
    }
}
