class Solution {
    public boolean validPalindrome(String s) {
        int n = s.length();
        char[] cArr = s.toCharArray();
        if (n <= 2) {
            return true;
        }
        int left = 0, right = n - 1;
        while (left < right && left < n && right >= 0) {
            if (cArr[left] != cArr[right]) {
                return isValid(s.substring(left + 1, right + 1)) 
                    || isValid(s.substring(left, right));
            }
            left++;
            right--;
        }
        return true;
    }
    
    public boolean isValid(String s) {
        if (s.length() <= 1) {
            return true;
        }
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) 
                return false;
            left++;
            right--;
        }
        return true;
    }
    
}
