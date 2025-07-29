class Solution {
    public boolean exist(char[][] board, String word) {
        char[][] visited = new char[board.length][board[0].length];
        for ( int i = 0; i < board.length; i++ ) {
            for ( int j = 0; j < board[0].length; j++ ) {
                if ( board[i][j] == word.charAt(0) ) {
                    if ( dfs(board,visited,word,0,i,j) ) return true;
                }
            }
        }
        return false;
    }
    private boolean dfs(char[][] board, char[][] visited, String word, int idx, int i, int j) {
        if ( idx == word.length() ) return true;
        if ( i >= board.length || i < 0 || j >= board[0].length || j < 0 ) return false;
        if ( board[i][j] != word.charAt(idx++) || visited[i][j] == '#' ) return false;
        int[][] dir = {{-1,0}, {1,0}, {0,-1}, {0,1}};
        char tmp = visited[i][j];
        visited[i][j] = '#';
        boolean res =  dfs(board,visited,word,idx,i+dir[0][0],j) || dfs(board,visited,word,idx,i+dir[1][0],j) || dfs(board,visited,word,idx,i,j+dir[2][1]) || dfs(board,visited,word,idx,i,j+dir[3][1]);
        visited[i][j] = tmp;
        return res;
    }
}