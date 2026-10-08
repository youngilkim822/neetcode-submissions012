class Solution {
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0) return 0;

        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int[][] directions = {{-1,0},{1,0},{0,-1},{0,1}};
        int count = 0;

        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j] == '1' && visited[i][j] == false){
                    Deque<int[]> deque = new ArrayDeque<>();
                    deque.addLast(new int[]{i, j});
                    visited[i][j] = true;

                    while(!deque.isEmpty()){
                        int size = deque.size();
                        for(int k=0; k<size; k++){
                            int[] current = deque.pollFirst();
                            for(int[] direction : directions){
                                int row = current[0] + direction[0];
                                int col = current[1] + direction[1];

                                if(row < 0 || col < 0 || row >= grid.length || col >= grid[0].length){
                                    continue;
                                }

                                if(grid[row][col] == '1' && visited[row][col] == false){
                                    deque.addLast(new int[]{row, col});
                                    visited[row][col] = true;
                                }
                            }
                        }                        
                    }
                    count++;
                }
            }
        }
        return count;
    }
}
