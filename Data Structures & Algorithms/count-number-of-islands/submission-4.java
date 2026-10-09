class Solution {
    private int[][] directions = {{-1,0},{1,0},{0,1},{0,-1}};
    public int numIslands(char[][] grid) {
        if(grid == null) return 0;

        boolean[][] visited = new boolean[grid.length][grid[0].length];
        Deque<int[]> deque = new ArrayDeque<>();
        int count = 0;
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j] == '1' && visited[i][j] == false){
                    deque.addLast(new int[]{i, j});
                    visited[i][j] = true;
                    grid[i][j] = 'a';
                    count++;
                    while(!deque.isEmpty()){
                        int[] poll = deque.pollFirst();
                        for(int[] direction : directions){
                            int row = poll[0] + direction[0];
                            int col = poll[1] + direction[1];

                            if(row<0 || col<0 || row>=grid.length || col>=grid[0].length || visited[row][col] == true){
                                continue;
                            }

                            if(grid[row][col] == '1'){
                                deque.addLast(new int[]{row, col});
                                visited[row][col] = true;
                            }
                        }
                    }
                }
            }
        }
        return count;
    }
}
