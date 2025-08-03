class Solution {
    private static final int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
    public void solve(char[][] board) {
        for ( int i = 0; i < board.length; i++ ) {
            for ( int j = 0; j < board[0].length; j++ ) {
                if ( i == 0 || i == board.length-1 || j == 0 || j == board[0].length-1 ) {
                    if ( board[i][j] == 'O' ) dfs(board,i,j);
                }
            }
        }
        for ( int i = 0; i < board.length; i++ ) {
            for ( int j = 0; j < board[0].length; j++ ) {
                if ( board[i][j] == 'T' ) board[i][j] = 'O';
                else board[i][j] = 'X';
            }
        }
    }
    private void dfs(char[][] board, int i, int j) {
        if ( i < 0 || i >= board.length || j < 0 || j >= board[0].length ) return;
        if ( board[i][j] != 'O' ) return;
        board[i][j] = 'T';
        for ( int[] dir : dirs ) dfs(board,i+dir[0],j+dir[1]);
    }
}