class Solution {
    public String[] map1 = new String[] {"","One","Two","Three","Four","Five","Six",
                                         "Seven","Eight","Nine"};
    public String[] map2 = new String[] {"Ten","Eleven","Twelve","Thirteen","Fourteen","Fifteen",
                                         "Sixteen","Seventeen","Eighteen","Nineteen"};
    public String[] map3 = new String[] {"","","Twenty","Thirty","Forty","Fifty",
                                         "Sixty","Seventy","Eighty","Ninety"};
    
    public String numberToWords(int num) {
        if (num == 0)
            return "Zero";
        int digits = getDigits(num);
        String result = "";
        if (digits > 9) 
            result = billion(num);
        else if (digits > 6)
            result = million(num);
        else if (digits > 3)
            result = thousand(num);
        else 
            result = threeDigitsToWords(num);      
        return result.trim().replaceAll(" +", " ");
    }
    
    public int getDigits(int num) {
        return num == 0 ? 1 : (int)Math.log10(num) + 1;
    }
    
    public String billion(int num) {
        int curr = num / 1000000000;
        int next = num % 1000000000;
        return threeDigitsToWords(curr) + " Billion " + million(next);
    }
    
    public String million(int num) {
        int curr = (num % 1000000000) / 1000000;
        int next = num % 1000000;
        return curr != 0 ? threeDigitsToWords(curr) + " Million " + thousand(next) : thousand(next);
    }
    
    public String thousand(int num) {
        if (num == 0)
            return "";
        int curr = (num % 1000000) / 1000;
        int next = num % 1000;
        return curr != 0 ? threeDigitsToWords(curr) + " Thousand " + threeDigitsToWords(next) : threeDigitsToWords(next);
    }
    
    public String threeDigitsToWords(int num) {
        int digits = getDigits(num);
        if (digits == 3)
            return map1[num / 100] + " Hundred " + twoDigitsToWords(num % 100);
        if (digits == 2)
            return twoDigitsToWords(num);
        if (digits == 1)
            return oneDigitsToWords(num);
        return "";
    }
    
    public String twoDigitsToWords(int num) {
        int digits = getDigits(num);
        if (digits == 1) {
            return oneDigitsToWords(num);
        }
        if (num < 20) {
            return map2[num - 10];
        } else {
            return map3[num / 10] + " " + oneDigitsToWords(num % 10);
        }
    }
    
    public String oneDigitsToWords(int num) {
        return map1[num];
    }
}
