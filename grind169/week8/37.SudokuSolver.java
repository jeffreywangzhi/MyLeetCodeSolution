class Solution {
    public void solveSudoku(char[][] board) {
        helper(0,0,board);
    }
    private boolean helper (int i, int j, char[][] board) {
        if ( i >= 9 ) return true;
        if ( j >= 9 ) return helper(i+1,0,board);
        if ( board[i][j] != '.' ) return helper(i,j+1,board);
        for ( char c = '1'; c <= '9'; c++ ) {
            if ( isValid(i,j,c,board) ) {
                board[i][j] = c;
                if ( helper(i,j+1,board) ) {
                    return true;
                } else board[i][j] = '.';
            }
        }
        return false;

    }
    private boolean isValid (int i, int j, char c, char[][] board) {
        for ( int k = 0; k < 9; k++ ) {
            if ( board[k][j] == c ) return false;
        }
        for ( int k = 0; k < 9; k++ ) {
            if ( board[i][k] == c ) return false;
        }
        int row = i - i%3;
        int col = j - j%3;
        for ( int m = row; m < row+3; m++ ) {
            for ( int n = col; n < col+3; n++ ) {
                if ( board[m][n] == c ) return false;
            }
        }
        return true;
    }
}