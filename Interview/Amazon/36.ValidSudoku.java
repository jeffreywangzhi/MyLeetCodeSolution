class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<Character> set = new HashSet<>();
        for ( int i = 0; i < board.length; i++ ) {
            for ( int j = 0; j < board[0].length; j++ ) {
                if ( board[i][j] == '.' ) continue;
                if ( set.contains(board[i][j]) ) return false;
                else set.add(board[i][j]);
            }
            set.clear();
        }
        for ( int i = 0; i < board[0].length; i++ ) {
            for ( int j = 0; j < board.length; j++ ) {
                if ( board[j][i] == '.' ) continue;
                if ( set.contains(board[j][i]) ) return false;
                else set.add(board[j][i]);
            }
            set.clear();
        }
        for ( int i = 0; i < board.length; i+=3 ) {
            for ( int j = 0; j < board[0].length; j+=3 ) {
                for ( int m = i; m < i+3; m++ ) {
                    for ( int n = j; n < j+3; n++ ) {
                        if ( board[m][n] == '.' ) continue;
                        if ( set.contains(board[m][n]) ) return false;
                        else set.add(board[m][n]);
                    }
                }
                set.clear();
            }
        }
        return true;
    }
}