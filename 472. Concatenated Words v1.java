class Solution {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> results = new ArrayList<>();
        Arrays.sort(words, (a, b) -> Integer.compare(a.length(), b.length()));
        Set<String> dict = new HashSet<>(); // !!! Do not build dict in every function call
        dict.add(words[0]);
        for (int i = 1; i < words.length; i++) {
            if (wordBreak(words, i, dict)) {
                results.add(words[i]);
            }
            dict.add(words[i]); // !!! dynamically add the word to dict. 
        }
        return results;
    }
    
    public boolean wordBreak(String[] words, int pos, Set<String> dict) {      
        // dp[i] : T or F for first i chars
        int n = words[pos].length();
        boolean dp[] = new boolean[n + 1];
        dp[0] = true;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if (!dp[j]) continue;
                if (dict.contains(words[pos].substring(j,i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }
}
