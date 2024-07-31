class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<String> set = new HashSet<>();
        for ( int i = 0; i < 9; i++ ) {
            for ( int j = 0; j < 9; j++ ) {
                if ( board[i][j] == '.' ) continue;
                StringBuilder a = new StringBuilder();
                a.append("(").append(board[i][j]).append(")").append(i);
                StringBuilder b = new StringBuilder();
                b.append(j).append("(").append(board[i][j]).append(")");
                StringBuilder c = new StringBuilder();
                c.append(i/3).append("(").append(board[i][j]).append(")").append(j/3);
                if ( set.contains(a.toString()) || set.contains(b.toString()) || set.contains(c.toString()) ) return false;
                set.add(a.toString());
                set.add(b.toString());
                set.add(c.toString());
            }
        } 
        return true;  
    }
}