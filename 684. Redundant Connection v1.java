class DSU {
    
    private int size;
    private int[] parent;
    private int[] rank;
    private int components;
    
    public DSU(int n) {
        size = n;
        parent = new int[size];
        rank = new int[size];
        components = n;
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
    }
    
    public int find(int x) {
        int root = x;
        // find
        while (root != parent[root]) {
            root = parent[root];
        }
        // path compression
        int curr = x;
        while ( curr != root) {
            int next = parent[curr];
            parent[curr] = root;
            curr = next;
        }
        return root;
    }
    
    public int getComponentCount() {
        return components;
    }
    
    public int getSize() {
        return size;
    }
    
    public boolean isConnected(int x, int y) {
        return find(x) == find(y);
    }
      
    public void union(int x, int y) {
        int xRoot = find(x), yRoot = find(y);
        if (xRoot == yRoot) {
            return;
        }
        
        if (rank[xRoot] < rank[yRoot]) {
            parent[xRoot] = yRoot;
            rank[yRoot] += rank[xRoot];
            rank[xRoot] = 0;
        } else {
            parent[yRoot] = xRoot;
            rank[xRoot] += rank[yRoot];
            rank[yRoot] = 0;
        }
        components--;
    }
}


class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int size = 1010;
        DSU dsu = new DSU(size);        
        for (int[] edge : edges) {
            if (dsu.isConnected(edge[0], edge[1])) {
                return edge;
            }
            dsu.union(edge[0], edge[1]);
        }
        throw new AssertionError();
    }

}
