class Solution {
    public boolean isValidSudoku(char[][] board) {
        if(board == null || board.length == 0 || board[0].length == 0) return false;

        // 1. validate the col
        Set<Character> set = new HashSet<>();
        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                if(board[i][j] == '.') continue;
                if(set.contains(board[i][j])){
                    return false;
                }
                set.add(board[i][j]);
            }
            set.clear();
        }

        // 2. validate the row
        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                if(board[j][i] == '.') continue;
                if(set.contains(board[j][i])){
                    return false;
                }
                set.add(board[j][i]);
            }
            set.clear();
        }

        // 3. validate the box
        for(int i=0; i<9; i+=3){
            for(int j=0; j<9; j+=3){
                if(!validateBox(board, i, j)){
                    return false;
                }
            }
        }
        return true;
    }

    private boolean validateBox(char[][] board, int row, int col){
        Set<Character> set = new HashSet<>();
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                if(board[row+i][col+j] == '.') continue;
                if(set.contains(board[row+i][col+j])){
                    return false;
                }
                set.add(board[row+i][col+j]);
            }
        }
        return true;
    }
}

/*
(0,0) (0,3) (0,6)
(3,0) (3,3) (3,6)
(6,0) (6,3) (6,6)

*/
