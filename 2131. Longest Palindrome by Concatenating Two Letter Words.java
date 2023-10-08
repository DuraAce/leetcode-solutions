class Solution {
    public int longestPalindrome(String[] words) {
        HashMap<String, Integer> freqMap = new HashMap<>();
        int usablePairCnt = 0;
        boolean hasOdd = false;

        
        for (String word: words) {
            freqMap.put(word, freqMap.getOrDefault(word, 0) + 1);
        }


        for (String word: freqMap.keySet()) {
            if (isSameChar(word)) {
                int wordCnt = freqMap.get(word);
                if (wordCnt % 2 == 0) {
                    usablePairCnt += wordCnt / 2;
                } else {
                    usablePairCnt += (wordCnt - 1) / 2;
                    hasOdd = true;
                }
                continue;
            }
            if (freqMap.containsKey(counterPartWord(word))) {
                usablePairCnt += Math.min(freqMap.get(word), freqMap.get(counterPartWord(word)));
                freqMap.put(word, 0);
                freqMap.put(counterPartWord(word), 0);
            }
        }


        return usablePairCnt * 4 + (hasOdd? 2 : 0);

    }

    private boolean isSameChar(String word) {
        if (word.length() != 2) 
            return false;
        if (word.charAt(0) == word.charAt(1)) 
            return true;
        else 
            return false;
    }

    private String counterPartWord(String word) {
        if (word.length() != 2) 
            return "";
        StringBuilder builder = new StringBuilder(2);
        builder.append(word.charAt(1));
        builder.append(word.charAt(0));
        return builder.toString();
    }
}
