/*
my solution
*/
class Solution {
    public int compress(char[] chars) {
        int n = chars.length;
        if (n == 1) {
            return 1;
        }
        int availableIndex = 0;
        char prevChar = chars[0];
        int cnt = 1;
        for (int i = 1; i < n; i ++) {
            char currChar = chars[i];
            if (currChar == prevChar) {
                cnt++;
                if (i != n - 1)
                    continue;
            }
            int digits = getDigits(cnt);
            chars[availableIndex] = prevChar;
            availableIndex++;
            if (cnt != 1) {
                for (int j = digits ; j > 0; j--) {
                    int currDigit = (cnt % (int)Math.pow(10, j) ) / (int)Math.pow(10, j - 1);
                    chars[availableIndex] = (char)('0' + currDigit);
                    availableIndex++;
                }
            }
            cnt = 1;
            if (i == n - 1 && currChar != prevChar) {
                chars[availableIndex] = currChar;
                availableIndex++;
            }
            prevChar = chars[i];            
        }
        return availableIndex;
    }
    
    public int getDigits(int n) {
        return (int)Math.log10(n) + 1;
    }
}

/*
from answers
*/
public int compress(char[] chars) {
        int indexAns = 0, index = 0;
        while(index < chars.length){
            char currentChar = chars[index];
            int count = 0;
            while(index < chars.length && chars[index] == currentChar){
                index++;
                count++;
            }
            chars[indexAns++] = currentChar;
            if(count != 1)
                for(char c : Integer.toString(count).toCharArray()) 
                    chars[indexAns++] = c;
        }
        return indexAns;
    }
