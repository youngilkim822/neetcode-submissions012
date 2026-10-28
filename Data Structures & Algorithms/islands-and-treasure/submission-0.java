class Solution {
    private Integer land = 2147483647; 
    private int[][] directions = {{-1,0},{1,0},{0,1},{0,-1}};

    public void islandsAndTreasure(int[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0) return;

        Deque<int[]> deque = new ArrayDeque<>();
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j] == 0){
                    deque.addLast(new int[]{i, j});
                }
            }
        }
        
        int count = 0;
        while(!deque.isEmpty()){
            int size = deque.size();
            count++;
            for(int k=0; k<size; k++){
                int[] poll = deque.pollFirst();
                for(int[] direction : directions){
                    int i = poll[0] + direction[0];
                    int j = poll[1] + direction[1];

                    if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || grid[i][j] != land){
                        continue;
                    }
                    grid[i][j] = count;
                    deque.addLast(new int[]{i,j});
                }   
            }
        }
    }
}
