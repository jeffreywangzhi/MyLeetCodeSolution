class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<Character> row = new HashSet<>();
        List<HashSet<Character>> col = new ArrayList<>();
        for ( int i = 0; i < 9; i++ ) col.add(new HashSet<>());
        List<List<HashSet<Character>>> box = new ArrayList<>();
        for ( int i = 0; i < 3; i++ ) {
            box.add(new ArrayList<>());
            for ( int j = 0; j < 3; j++ ) box.get(i).add(new HashSet<>());
        }
        for ( int i = 0; i < board.length; i++ ) {
            for ( int j = 0; j < board[0].length; j++ ) {
                char cur = board[i][j];
                if ( cur == '.' ) continue;
                if ( row.contains(cur) ) return false;
                else row.add(cur);
                if ( col.get(j).contains(cur) ) return false;
                else col.get(j).add(cur);
                int r = i/3, c = j/3;
                if ( box.get(r).get(c).contains(cur) ) return false;
                else box.get(r).get(c).add(cur);
            }
            row.clear();
        }
        return true;
    }
}