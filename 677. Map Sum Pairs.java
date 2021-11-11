class MapSum {
    
    class TrieNode {
        Map<Character, TrieNode> children;
        int val;
        public TrieNode() {
            this.children = new HashMap<>();
            this.val = 0;
        }
    }

    TrieNode root;
    
    public MapSum() {
        this.root = new TrieNode();        
    }
    
    public void insert(String key, int val) {
        TrieNode curr = root;
        for (char c : key.toCharArray()) {
            if (!curr.children.containsKey(c)) 
                curr.children.put(c, new TrieNode());
            curr = curr.children.get(c);
        }
        curr.val = val;
    }
    
    public int sum(String prefix) {
        TrieNode curr = root;
        for (char c : prefix.toCharArray()) {
            if (!curr.children.containsKey(c)) 
                return 0;
            curr = curr.children.get(c);
        }
        int  sum = helper(curr);
        return sum;
    }
    
    public int helper(TrieNode curr) {
        int sum = curr.val;
        for (TrieNode child : curr.children.values()) {
            sum += helper(child);
        }
        return sum;
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */
