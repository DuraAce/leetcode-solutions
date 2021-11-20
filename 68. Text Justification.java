class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int n = words.length;
        // construct array of lenght
        int[] lens = new int[n];
        for (int i = 0; i < n; i++) {
            lens[i] = words[i].length();
        }
        int currentLen = 0, startLoc = 0;
        for (int i = 0; i < n; i++) {
            currentLen += lens[i];
            if (currentLen > maxWidth) {
                if (startLoc == i - 1) {
                    constructLastLine (words, maxWidth, result, startLoc, startLoc) ;
                } else {
                    constructLine(words, maxWidth, result, startLoc, i - 1, lens);
                }
                
                currentLen = 0;
                startLoc = i;
                i--;                
            } else {
                // add length of a space
                if (i == n - 1) {
                    constructLastLine (words, maxWidth, result, startLoc, i) ;
                    return result;
                }
                currentLen++;
            }
        }
        return result;
    }
    
    public void constructLine (String[] words, int maxWidth, List<String> result, int startLoc,
                              int endLoc, int[] lens) {
        int charLen = 0;
        for (int i = startLoc; i <= endLoc; i++) {
            charLen += lens[i];
        }
        int space = (maxWidth - charLen) / (endLoc - startLoc);
        int extraSpace = maxWidth - charLen - space * (endLoc - startLoc) ;
        //System.out.println(space + "," + firstSpace);
        String res = "";
        if (endLoc == startLoc + 1) {
            res = words[startLoc] + repeatSpace(space) + words[endLoc];
            result.add(res);
            //System.out.println(res);
            return;
        }
        for (int i = 0; i < extraSpace; i++) {
            res = res + words[startLoc + i] +  repeatSpace(space + 1);
        }
        for (int i = startLoc + extraSpace; i < endLoc; i++) {
            res += words[i] + repeatSpace(space);
        }
        res += words[endLoc];
        result.add(res);
        //System.out.println(res);
        return;
    }
    
    public void constructLastLine (String[] words, int maxWidth, List<String> result, 
                                   int startLoc,  int endLoc) {
        String res = "";
        for (int i = startLoc; i < endLoc; i++) {
            res = res + words[i] + " ";
        }
        res += words[endLoc];
        int remainSpace = maxWidth - res.length();
        res += repeatSpace(remainSpace);
        result.add(res);
        //System.out.println(res);
        return;        
    }
    
    public String repeatSpace (int n) {
        String res = "";
        for (int i = 0; i < n; i++) {
            res += " ";
        }
        return res;
    }
}
