class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) 
            return 0;
        char[] cArr = s.toCharArray();
        int start = 0, end = 0;
        int n = cArr.length;
        int maxLen = 0;
        Map<Character, Integer> dict = new HashMap<>();
        while (end < n) {
            if (!dict.containsKey(cArr[end])) {
                dict.put(cArr[end], end);
                end++;
            } else {
                maxLen = Math.max(maxLen, end - start);
                int prevEnd = dict.get(cArr[end]);
                for (int i = start; i <= prevEnd; i++) {
                    dict.remove(cArr[i]);
                }
                start = prevEnd + 1;
                dict.put(cArr[end], end);
                end++;
            }
        }
    return Math.max(maxLen, n - start);
    }        
}
