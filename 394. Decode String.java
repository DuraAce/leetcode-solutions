/*
straight forward iterate. Recursive
*/
class Solution {
    public String decodeString(String s) {
        return getValid(s);
    }
    
    public String helper(int n, String sub) {
        String result = "";
        for (int i = 0; i < n; i++) {
            result += getValid(sub);
        }
        return result;
    }
    
    public String getValid(String s) {
        Stack<Character> st = new Stack<>();
        String repeatLen = "";
        int start = 0;
        for (int i = 0; i < s.toCharArray().length; i++) {
            if (Character.isLetter(s.charAt(i)))
                continue;
            if (Character.isDigit(s.charAt(i)))
                repeatLen += s.charAt(i);
            if (s.charAt(i) == '[') {
                start = i;
                st.push('[');
                break;
            }
        }
        int repeat = repeatLen.length() == 0? 0 : Integer.parseInt(repeatLen);
        if (start == 0) 
            return s;
        int end = start;
        for (int i = start + 1; i < s.length(); i++) {
            if (s.charAt(i) == '[') 
                st.push('[');
            if (s.charAt(i) == ']') {
                st.pop();
                if (st.size() == 0) {
                    end = i;
                    break;
                }
            }                
        }
        return s.substring(0, start - (int)(Math.log10(repeat) + 1)) 
            + helper(repeat, s.substring(start + 1, end))
            + getValid(s.substring(end + 1, s.length()));
    }
}


/* 
two stacks
*/
class Solution {
    public String decodeString(String s) {
        Stack<Integer> cnt = new Stack<>();
        Stack<StringBuilder> str = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int repeat = 0;
        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                repeat = repeat * 10 + ch - '0';
            }
            if (Character.isLetter(ch)) {
                sb.append(ch);
            }
            if (ch == '[') {
                cnt.push(repeat);
                repeat = 0;
                str.push(sb);
                sb = new StringBuilder();
            }
            if (ch == ']') {
                int k = cnt.pop();
                StringBuilder curr = str.pop();
                for (int i = 0; i < k; i++) {
                    curr.append(sb);
                }
                //str.push(curr);
                sb = curr;
                System.out.println(str.size());
            }
        }
        return sb.toString();
    }
}
