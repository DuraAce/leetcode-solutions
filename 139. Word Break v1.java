class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        // list to hashset
        Set<String> dictSet = new HashSet<>();
        for (String word : wordDict) {
            dictSet.add(word);
        }
        
        // dp. dp[i] = first ith char can be found in dict
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                //System.out.println(s.substring(j + 1, i));
                if (dp[j] && wordDict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
            //System.out.println(s.charAt(i - 1) + " " + dp[i]);
        }
        return dp[n];
    }
}
