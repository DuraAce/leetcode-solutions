class Solution {
    public char[][] mappings = new char[][] {
        {},
        {},
        {'a','b','c'},
        {'d','e','f'},
        {'g','h','i'},
        {'j','k','l'},
        {'m','n','o'},
        {'p','q','r','s'},
        {'t','u','v'},
        {'w','x','y','z'}
    };
        
    public List<String> letterCombinations(String digits) {
        List<String> results = new  ArrayList<>();
        if (digits.length() == 0) {
            return results;
        }
        dfs(digits, 0, mappings, "", results);
        return results;
    }
    
    //dfs
    public void dfs(String digits, int index, char[][] mappings, String sub, 
                    List<String> results) {
        if (index == digits.length() - 1) {
            for (char c : mappings[digits.charAt(index) - '0']) {
                results.add(sub + c);
            }
            return;
        }
        
        for (char c : mappings[digits.charAt(index) - '0']) {
            dfs(digits, index + 1, mappings, sub + c, results);
        }        
    }
}
