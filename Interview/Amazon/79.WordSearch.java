class Solution {
    public boolean exist(char[][] board, String word) {
        for ( int i = 0; i < board.length; i++ ) {
            for ( int j = 0; j < board[0].length; j++ ) {
                if ( board[i][j] == word.charAt(0) ) {
                    if ( dfs(i,j,0,board,word) ) return true;
                }
            }
        }
        return false;
    }
    private boolean dfs(int i, int j, int idx, char[][] board, String word) {
        if ( idx >= word.length() ) return true;
        if ( i < 0 || i >= board.length || j < 0 || j >= board[0].length ) return false;
        if ( board[i][j] == '#' || board[i][j] != word.charAt(idx++) ) return false;
        char tmp = board[i][j];
        board[i][j] = '#';
        boolean res = dfs(i+1,j,idx,board,word) || dfs(i-1,j,idx,board,word) || dfs(i,j+1,idx,board,word) || dfs(i,j-1,idx,board,word);
        board[i][j] = tmp;
        return res;
    }
}