/*
version 1
*/
class Trie {
    
    class TrieNode {
        Map<Character, TrieNode> children;
        boolean isWord;
        public TrieNode() {
            this.children = new HashMap<>();
        }
    }

    TrieNode root;
    
    public Trie() {
        this.root = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode curr = root;
        for (char c : word.toCharArray()) {
            if (!curr.children.containsKey(c))
                curr.children.put(c, new TrieNode());
            curr = curr.children.get(c);               
        }
        curr.isWord = true;
    }
    
    public boolean search(String word) {
        TrieNode curr = root;
        for (char c : word.toCharArray()) {
            if (!curr.children.containsKey(c))
                return false;   
            curr = curr.children.get(c);
        }
        return curr.isWord;
    }
    
    public void delete(String word) {   
        if (!search(word))
            return;
        TrieNode curr = root;
        char[] cArray = word.toCharArray();
        for (int i = 0; i < cArray.length - 1; i++) {            
            curr = curr.children.get(cArray[i]);
        }
        if (curr.children.get(cArray[cArray.length - 1]).children.size() == 0) {
            curr.children.remove(cArray[cArray.length - 1]);
        }        
    }
    
    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        for (char c : prefix.toCharArray()) {
            if (!curr.children.containsKey(c)) 
                return false;
            curr = curr.children.get(c);
        }
        return true;
    }
}

class Solution {
    
    public int[][] dirs = new int[][] {{1,0},{0,1},{-1,0},{0,-1}};
    
    public List<String> findWords(char[][] board, String[] words) {
        // init trie
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }
        List<String> result = new ArrayList<>();
        Set<String> found = new HashSet<>();
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                Set<Integer> visited = new HashSet<>();
                StringBuilder sb = new StringBuilder();
                dfs(board, trie, i, j, sb, visited, found);
            }
        }
        for (String s : found) {
            result.add(s);
        }
        return result;
    }
    
    // dfs
    public void dfs(char[][] board, Trie trie, int x, int y, StringBuilder sb, 
                   Set<Integer> visited, Set<String> found) {
        int m = board.length;
        int n = board[0].length;
        char c = board[x][y];
        sb.append(c);
        if (!trie.startsWith(sb.toString())) {
            sb.deleteCharAt(sb.length() - 1);
            return;            
        }        
        visited.add(x * n + y);
        if (trie.search(sb.toString())) {
            found.add(sb.toString());
            trie.delete(sb.toString());
        }
        for (int[] dir : dirs) {
            int nX = x + dir[0];
            int nY = y + dir[1];
            if (visited.contains(nX * n + nY))
                continue;
            if (!(0 <= nX && nX < m && 0 <= nY && nY < n))
                continue;
            dfs(board, trie, nX, nY, sb, visited, found);                
        }
        visited.remove(x * n + y);
        sb.deleteCharAt(sb.length() - 1);
    }
    
}
