class Solution {
    public boolean exist(char[][] board, String word) {
        for ( int i = 0; i < board.length; i++ ) {
            for ( int j = 0; j < board[0].length; j++ ) {
                if ( helper(board,word,1,i,j) ) return true;
            }
        }
        return false;
    }
    private boolean helper(char[][] board, String word, int level, int i, int j) {
        if ( i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(level-1) ) return false;
        if ( level == word.length() ) return true;
        char temp = board[i][j];
        board[i][j] = '#';
        boolean res = helper(board,word,level+1,i+1,j) || helper(board,word,level+1,i-1,j) || helper(board,word,level+1,i,j+1) || helper(board,word,level+1,i,j-1);
        board[i][j] = temp;
        return res;
    }
}