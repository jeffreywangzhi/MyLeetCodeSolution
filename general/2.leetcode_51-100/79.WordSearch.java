class Solution {
    public boolean exist(char[][] board, String word) {
        boolean res = false;
        for ( int i = 0; i < board.length; i++ ) {
            for ( int j = 0; j < board[0].length; j++ ) {
                if ( board[i][j] == word.charAt(0) ) res = ( dfs(board, word, i, j, 0) || res );
            }
        }
        return res;
    }
    private boolean dfs(char[][] board, String word, int i, int j, int index) {
        boolean res = false;
        if ( i < 0 || i >= board.length || j < 0 || j >= board[0].length ) return false;
        if ( board[i][j] == word.charAt(index) && index == word.length()-1 ) return true;
        if ( board[i][j] == word.charAt(index) ) {
            char temp = board[i][j];
            board[i][j] = '#';
            res = dfs(board, word, i-1, j, index+1) || dfs(board, word, i+1, j, index+1) || dfs(board, word, i, j+1, index+1) || dfs(board, word, i, j-1, index+1);
            board[i][j] = temp;
        }
        return res;
    }
}