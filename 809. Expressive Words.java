class Solution {
    public int expressiveWords(String s, String[] words) {
        List<Character> sComp = new ArrayList<>();
        List<Integer> sCnt = new ArrayList<>();
        compress(s, sComp, sCnt);
        int result = 0;
        for (int i = 0; i < words.length; i++) {
            List<Character> qComp = new ArrayList<>();
            List<Integer> qCnt = new ArrayList<>();
            compress(words[i], qComp, qCnt);
            if (isStretchy(sComp, sCnt, qComp, qCnt))
                result++;
        }
        return result;
    }
    
    public void compress(String s, List<Character> compressed, List<Integer> charCnt){
        int n = s.length();
        compressed.add(s.charAt(0));
        int currentCnt = 1;
        for (int i = 1; i < n; i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                currentCnt++;
                continue;
            }
            charCnt.add(currentCnt);
            compressed.add(s.charAt(i));
            currentCnt = 1;
        }
        charCnt.add(currentCnt);
    }
    
    public boolean isStretchy(List<Character> compressed1, List<Integer> charCnt1,
                             List<Character> compressed2, List<Integer> charCnt2) {
        if (compressed1.size() != compressed2.size())
            return false;
        for (int i = 0; i < compressed1.size(); i++) {
            if (compressed1.get(i) != compressed2.get(i))
                return false;
            if (charCnt1.get(i) < charCnt2.get(i))
                return false;
            if (charCnt1.get(i) > charCnt2.get(i) && charCnt1.get(i) < 3)
                return false;
        }
        return true;
    }
}
