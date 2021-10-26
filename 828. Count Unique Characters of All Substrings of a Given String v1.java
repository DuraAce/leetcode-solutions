class Solution {
    public int uniqueLetterString(String s) {
        int n = s.length();
        int[] dp = new int[n];
        int[] charLastPos = new int[26];
        int[] charSecondLastPos = new int[26];
        Arrays.fill(charLastPos, -1);
        Arrays.fill(charSecondLastPos, -1);
        dp[0] = 1;
        int result = dp[0];
        charLastPos[s.charAt(0) - 'A'] = 0;
        for (int i = 1; i < n; i++) {
            dp[i] = dp[i - 1] + i - 2 * charLastPos[s.charAt(i) - 'A'] 
                    + charSecondLastPos[s.charAt(i) - 'A'];
            //System.out.println(dp[i]);
            result += dp[i];
            charSecondLastPos[s.charAt(i) - 'A'] = charLastPos[s.charAt(i) - 'A'];
            charLastPos[s.charAt(i) - 'A'] = i;            
        }
        return result;
    }
}
