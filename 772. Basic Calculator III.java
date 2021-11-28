class Solution {
    public int calculate(String s) {
        Stack<Integer> nums = new Stack<>();
        Stack<Character> signs = new Stack<>();   
        s = s.trim();
        signs.push('(');
        nums.push(0);
        signs.push('+');
        int currentNum = 0;
        int n = s.length();
        int index = 0;
        while (index < n) {
            char c = s.charAt(index);
            if (c == ' ') {  
                index++;
                continue;
            } else if (!Character.isDigit(c)) {
                signs.push(c);
                if (c == ')') {
                    int tmp = sum(nums, signs);
                    pushNum(nums, signs, tmp);
                }
                index++;
            } else if (Character.isDigit(c)) {                
                while (index < n && Character.isDigit(s.charAt(index))) {
                    currentNum = currentNum * 10 + (s.charAt(index) - '0');
                    index++;
                }
                pushNum(nums, signs, currentNum);
                currentNum = 0;
            }
        }
        signs.push(')');

        return sum(nums, signs);
    }
    
    public int sum(Stack<Integer> nums, Stack<Character> signs) {
        int result = 0;
        char sign = signs.pop();
        while(signs.peek() != '(') {
            sign = signs.pop();
            int num = nums.pop();
            if (sign == '+')
                result += num;
            if (sign == '-')
                result -= num;
        }
        result += nums.pop();
        signs.pop();
        return result;
    }
    
    public void pushNum(Stack<Integer> nums, Stack<Character> signs, int curr) {
        char prevSign = signs.peek();
        int toPush = curr;
        if (prevSign == '*') {
            toPush = nums.pop() * curr;
            signs.pop();
            pushNum(nums, signs, toPush);
        } else if (prevSign == '/') {
            toPush = nums.pop() / curr;
            signs.pop();
            pushNum(nums, signs, toPush);
        } else {
            nums.push(toPush);
        }
    }
}
