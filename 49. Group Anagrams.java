class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<Integer>> mappings = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            String newStr = reOrder(strs[i]);
            mappings.putIfAbsent(newStr, new ArrayList<>());
            mappings.get(newStr).add(i);            
        }
        List<List<String>> results = new ArrayList<>();
        for (String s : mappings.keySet()) {
            List<String> result = new ArrayList<>();
            List<Integer> indexes = mappings.get(s);
            for(int i : indexes) {
                result.add(strs[i]);
            }
            results.add(result);
        }
        return results;
    }
    
    public String reOrder(String s) {
        char[] sArr = s.toCharArray();
        Arrays.sort(sArr);
        return String.valueOf(sArr);
    }
}
