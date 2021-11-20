class Solution {
    public List<String> generateParenthesis(int n) {
        boolean[] helper = new boolean[n * 2];
        List<String> results = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            helper[i] = true;
        }
        dfs(helper, results, n - 1, 2 * n - 1);
        return results;
    }
    
    public void dfs(boolean[] helper , List<String> results, int start, int end) {
        if (start < 0 || end > helper.length - 1)
            return;
        addResult(helper, results);
        for (int i = 1; start + i < end; i++) {
            boolean[] newHelper = helper.clone();
            newHelper[start] = false;
            newHelper[start + i] = true;
            if (!isValid(newHelper, start + i))
                break;
            dfs(newHelper, results, start - 1, start + i);
        }
    }
    
    public void addResult(boolean[] helper , List<String> results) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < helper.length; i++) {
            if (helper[i])
                sb.append('(');
            else 
                sb.append(')');                
        }
        results.add(sb.toString());        
    }
    
    public boolean isValid(boolean[] helper , int index) {
        int cntTrue = 0, cntFalse = 0;
        for (int i = index; i < helper.length; i++) {
            if (helper[i])
                cntTrue++;
            else 
                cntFalse++;
        }
        return (cntTrue <= cntFalse) ? true : false;
    }
}
