class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet record = new HashSet();
        for ( int i = 0; i < 9; i++ ) {
            for ( int j = 0; j < 9; j++ ) {
                if ( board[i][j] == '.' ) continue;
                StringBuilder row_st = new StringBuilder();
                row_st.append(Integer.toString(i));
                row_st.append("(");
                row_st.append(board[i][j] - '1');
                row_st.append(")");
                
                StringBuilder col_st = new StringBuilder();
                col_st.append("(");
                col_st.append(board[i][j] - '1');
                col_st.append(")");
                col_st.append(Integer.toString(j));

                StringBuilder cel_st = new StringBuilder();
                cel_st.append(Integer.toString(i/3));
                cel_st.append("(");
                cel_st.append(board[i][j] - '1');
                cel_st.append(")");
                cel_st.append(Integer.toString(j/3));

                if ( record.contains(row_st.toString()) || record.contains(col_st.toString()) ||record.contains(cel_st.toString()) ) return false;
                else
                    record.add(row_st.toString());
                    record.add(col_st.toString());
                    record.add(cel_st.toString());
            }
        }
        return true;
    }
}