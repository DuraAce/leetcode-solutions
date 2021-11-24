class Solution {
    public int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public boolean found = false;
    
    public boolean exist(char[][] board, String word) {
        
        int m = board.length, n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                Set<Integer> visited = new HashSet<>();
                dfs(board, word, 0, i, j, visited);
                if (found)
                    break;
            }
        }
        return found;
    }
    
    // dfs
    public void  dfs(char[][] board, String word, int index, 
                       int x, int y, Set<Integer> visited) {
        if (found)
            return ;
        if (board[x][y] != word.charAt(index))
            return ;
        int m = board.length, n = board[0].length, l = word.length();
        visited.add(x * n + y);
        if (index == l - 1) {
            //System.out.println("found!");
            found = true;       
            return ;
        } 
        for (int[] dir : dirs) {
            int newX = x + dir[0];
            int newY = y + dir[1];
            if (0 <= newX && newX < m && 0 <= newY && newY < n 
                && !visited.contains(newX * n + newY)) {
                dfs(board, word, index + 1, newX, newY, visited);
                visited.remove(newX * n + newY);
            }
                
        }
        return ;
    }
}
