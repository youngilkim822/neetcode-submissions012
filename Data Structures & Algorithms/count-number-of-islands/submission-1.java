class Solution {
    private int[][] directions = {{-1,0},{1,0},{0,-1},{0,1}};
    public int numIslands(char[][] grid) {
        if(grid == null) return 0;

        boolean[][] visited = new boolean[grid.length][grid[0].length];
        // iterate grid, grid[i][j] = '1'
        int count = 0;
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j] == '1' && visited[i][j] == false){
                    recurse(grid, visited, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    private void recurse(char[][] grid, boolean[][] visited, int i, int j){
        // exit
        if(grid[i][j] != '1') return;
        if(visited[i][j] == true) return;

        visited[i][j] = true;

        // visit neighboring nodes < > ^ v
        for(int[] direction : directions){
            int row = i + direction[0];
            int col = j + direction[1];

            if(row < 0 || col < 0 || row >= grid.length || col >= grid[0].length){
                continue;
            } 

            if(grid[row][col] == '1'){
                recurse(grid, visited, row, col);
            }
        }
    }
}
