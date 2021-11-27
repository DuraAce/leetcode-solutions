class Solution {
    public int[][] dirs = new int[][] {{0,1}, {1,0}, {0,-1},{-1,0}};
    
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;        
        Set<Integer> visited = new HashSet<>();
        List<Integer> results = new ArrayList<>();
        int x = 0, y = 0, dirIndex = 0;
        results.add(matrix[x][y]);
        visited.add(x * n + y);
        for (int i = 1; i < m * n; i++) {
            x += dirs[dirIndex % 4][0];
            y += dirs[dirIndex % 4][1];
            if (!doesHitBoundary(matrix, visited, x, y)) {
                results.add(matrix[x][y]);
                visited.add(x * n + y);                
            } else {
                i--;
                x -= dirs[dirIndex % 4][0];
                y -= dirs[dirIndex % 4][1];
                dirIndex++;
            }
        }
        return results;
    }
    
    public boolean doesHitBoundary(int[][] matrix, Set<Integer> visited, int x, int y) {
        int m = matrix.length;
        int n = matrix[0].length;
        if (visited.contains(x * n + y))
            return true;
        if (x < 0 || x > m - 1 || y < 0 || y > n - 1) 
            return true;
        return false;
    }
}
