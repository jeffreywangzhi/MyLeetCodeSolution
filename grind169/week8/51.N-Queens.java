class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        char[][] board = new char[n][n];
        for ( char[] c : board ) Arrays.fill(c,'.');
        helper(0,n,board,res);
        return res;
    }
    private void helper(int row, int n, char[][] board, List<List<String>> res) {
        if ( row >= n ) {
            res.add(construct(board));
            return;
        }
        for ( int i = 0; i < n; i++ ) {
            if ( isValid(row,i,board) ) {
                board[row][i] = 'Q';
                helper(row+1,n,board,res);
                board[row][i] = '.';
            }
        }
    }
    private boolean isValid(int i, int j, char[][] board) {
        for ( int k = 0; k < i; k++ ) {
            if ( board[k][j] == 'Q' ) return false;
        }
        for ( int m = i-1, n = j-1; m >= 0 && n >= 0; m--, n-- ) {
            if ( board[m][n] == 'Q' ) return false;
        }
        for ( int m = i-1, n = j+1; m >=0 && n < board[0].length; m--, n++ ) {
            if ( board[m][n] == 'Q' ) return false;
        }
        return true;
    }
    private List<String> construct(char[][] board) {
        List<String> res = new ArrayList<>();
        for ( char[] c : board ) res.add(new String(c));
        return res;
    }
}