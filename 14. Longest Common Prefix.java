class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 1) 
            return strs[0];
        char[] merge = strs[0].toCharArray();
        for (int i = 1; i < strs.length; i++) {
            if (strs[i].length() < merge.length) 
                merge[strs[i].length()] = '0';
            for (int j = 0; j < Math.min(strs[i].length(), merge.length); j++) {
                if (strs[i].charAt(j) != merge[j]) {
                    merge[j] = '0';
                    break;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (char c : merge) {
            if (c != '0')
                sb.append(c);
            else 
                break;                
        }
        return sb.toString();
    }
}
