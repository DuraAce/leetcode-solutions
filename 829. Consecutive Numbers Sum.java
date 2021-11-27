class Solution {
    public int consecutiveNumbersSum(int n) {
        int cnt = 1;
        int div = 1;
        int first = n;
        while (n / div > div / 2 ) {
            //System.out.println(div);
            div++;
            if (div % 2 == 0 && n % div == div / 2) {
                first = n / div + 1 - div / 2;
                if (first > 0)
                    cnt++;
                else 
                    return cnt;                
            } else if (div % 2 == 1 && n % div == 0 ) {
                first =  n /div - div / 2;
                if (first > 0)
                    cnt++;
                else 
                    return cnt;
            }                 
        }
        return cnt;
    }
}
