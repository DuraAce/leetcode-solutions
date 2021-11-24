class Solution {
    public int minTaps(int n, int[] ranges) {
        Map<Integer, Integer> startMap = new HashMap<>();
        for (int i = 0; i <= n; i++) {
            int start = i - ranges[i];
            if (start < 0)
                start = 0;
            int end = i + ranges[i];
            if (end > n)
                end = n;
            int currEnd = startMap.getOrDefault(start, start);
            startMap.put(start, Math.max(currEnd, end));
        }
        
        int cnt = 0, start = 0, end = 0;
        while (end <= n) {
            end = startMap.get(start);
            cnt++;
            if (end == n) 
                return cnt;
            int maxEnd = end;
            int maxStart = start;
            for (int i = start; i <= end; i++) {
                if (startMap.containsKey(i)) {
                    if (startMap.get(i) > maxEnd) {
                        maxEnd = startMap.get(i);
                        maxStart = i;
                    }
                }
                
            }
            if (maxEnd <= end) 
                    return -1a;
            start = maxStart;
            end = maxEnd;
        }
        return cnt;
    }
}
