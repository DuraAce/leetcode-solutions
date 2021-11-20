class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        if (n == 1) 
            return s;
        // dp[i][j] : true if from i to j is Palindrome
        boolean[][] dp = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                dp[i][j] = true;
            }            
        }
        
        int max = 0;
        int[] result = new int[2];
        for (int j = 1; j < n; j++) {
            for (int i = 0; i < j; i++) {
                dp[i][j] = dp[i + 1][j - 1] && (s.charAt(i) == s.charAt(j));
                //System.out.println(i + "," + j + ": " + dp[i][j]);
                if (dp[i][j] && (j - i + 1 > max) ) {
                    max = j - i + 1 ;
                    result[0] = i;
                    result[1] = j;
                }
            }
        }
        return s.substring(result[0], result[1] + 1);
    }
}
