class Solution {
    private int[][] directions = {{-1,0},{1,0},{0,1},{0,-1}};
    public int maxAreaOfIsland(int[][] grid) {
        if(grid == null) return 0;

        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int ans = 0;
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j] == 1 && visited[i][j] == false){
                    ans = Math.max(ans, recurse(grid, visited, i, j, 1));
                }
            }
        }
        return ans;
    }

    private int recurse(int[][] grid, boolean[][] visited, int i, int j, int area){
        if(grid[i][j] != 1) return 0;
        if(visited[i][j] == true) return 0;

        int count = 1;
        visited[i][j] = true;
        for(int[] direction : directions){
            int row = i + direction[0];
            int col = j + direction[1];

            if(row < 0 || col < 0 || row >= grid.length || col >= grid[0].length){
                continue;
            }

            //if(grid[row][col] == 1){
                count += recurse(grid, visited, row, col, area+1);
            //}
        }
        return count;
    }
}
