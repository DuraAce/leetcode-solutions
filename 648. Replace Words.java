class Solution {
    class Trie{
        class TrieNode {
            Map<Character, TrieNode> children;
            boolean isPrefix;
            public TrieNode() {
                this.children = new HashMap<>();
            }
        }
        
        TrieNode root;
        public Trie() {
            this.root = new TrieNode();
        }
        
        public void insert(String prefix) {
            TrieNode curr = root;
            for (char c : prefix.toCharArray()) {
                if (!curr.children.containsKey(c))
                    curr.children.put(c , new TrieNode());
                curr = curr.children.get(c);
            }
            curr.isPrefix = true;
        }
        
        public String search(String word) {
            StringBuilder sb = new StringBuilder();
            TrieNode curr = root;
            for (char c : word.toCharArray()) {
                //System.out.println(c + "-->");
                if (curr.children.containsKey(c)) {
                    sb.append(c);
                    curr = curr.children.get(c);
                    if (curr.isPrefix) 
                        return sb.toString();
                }  else {
                    return word;
                }
            }
            return word;
        }
    }
    public String replaceWords(List<String> dictionary, String sentence) {
        Trie dict = new Trie();
        for (String prefix : dictionary) 
            dict.insert(prefix);
        String[] words = sentence.split(" ");
        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            sb.append(dict.search(word));
            sb.append(" ");
        }
        String result = sb.toString();
        return result.substring(0, result.length() - 1);
    }
}
