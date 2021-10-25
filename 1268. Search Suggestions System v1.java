// https://leetcode.com/problems/search-suggestions-system/submissions/

class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products);
        List<List<String>> results = new ArrayList<>();
        // Binary search of the first i chars
        for (int i = 0; i < searchWord.length(); i++) {
            searchChar(products, searchWord, i, results);
        }
        return results;
    }
    
    public void searchChar(String[] products, String searchWord, int i, 
                           List<List<String>> results) {
        int start = 0, end = products.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (compareSubstring(searchWord, products[mid], i) > 0) {
                start = mid;
            } else {
                end = mid;
            }
        }
        List<String> result = new ArrayList<>();
        if (compareSubstring(searchWord, products[start], i) == 0) {
            addStringToResult(result, products, start, searchWord, i);
        } else if (compareSubstring(searchWord, products[end], i) == 0) {
            addStringToResult(result, products, end, searchWord, i);
        }
        results.add(result);
    }
    
    public int compareSubstring(String str1, String str2, int i) {
        String substr1 = str1.substring(0, i + 1);
        String substr2;
        if (str2.length() <= i) {
            substr2 = str2;
        } else {
            substr2 = str2.substring(0, i + 1);
        }
        return substr1.compareTo(substr2);
    }
    
    public void addStringToResult(List<String> result, String[] products, int pos,
                                 String searchWord, int i) {
        int end = (products.length - pos > 2) ? 3 : products.length - pos;
        for (int j = 0; j < end; j++) {
            if (compareSubstring(searchWord, products[pos + j], i) < 0) {
                continue;
            }
            result.add(products[pos + j]);
        }
    }
}
