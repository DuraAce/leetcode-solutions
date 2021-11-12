/*
dp, o(n^2)
*/
class Solution {
    public int countBinarySubstrings(String s) {
        int n = s.length();
        if (n <= 1) 
            return 0;
        int[] dp = new int[n];
        dp[0] = 0;
        for (int i = 1; i < n; i++) {
            if (s.charAt(i) != s.charAt(i - 1)) 
                dp[i] = dp[i - 1] + 1;
            else {
                int cnt = 0, j = i;
                while (j >= 0) {
                    if (s.charAt(j) == s.charAt(i)) 
                        cnt++;
                    else 
                        break;
                    j--;                        
                }
                while (j >= 0) {
                    if (s.charAt(j) != s.charAt(i))
                        cnt--;
                    else 
                        break;
                    j--;
                }
                if (cnt <= 0)
                    dp[i] = dp[i - 1] + 1;
                else 
                    dp[i] = dp[i - 1];
            }
            //System.out.println(dp[i]);
        }
        return dp[n - 1];
    }
}


/*
math, O(n)
*/
class Solution {
    public int countBinarySubstrings(String s) {
        if (s.length() <= 1)
            return 0;
        int result = 0, cntPrev = 0, cntCurr = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                cntCurr++;
            } else {
                result += Math.min(cntPrev, cntCurr);
                cntPrev = cntCurr;
                cntCurr = 1;
            }
        }
        result += Math.min(cntPrev, cntCurr);
        return result;            
    }
}
