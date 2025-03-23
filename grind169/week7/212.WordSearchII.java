class Solution {
    private class Trie {
        Trie[] next = new Trie[26];
        String word = null;
    }
    private Trie buildTrie(String[] words) {
        Trie root = new Trie();
        for ( String word : words ) {
            Trie p = root;
            for ( char c : word.toCharArray() ) {
                if ( p.next[c-'a'] == null ) p.next[c-'a'] = new Trie();
                p = p.next[c-'a'];
            }
            p.word = word;
        }
        return root;
    }
    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        Trie trie = buildTrie(words);
        for ( int i = 0; i < board.length; i++ ) {
            for ( int j = 0; j < board[0].length; j++ ) {
                if ( trie.next[board[i][j]-'a'] != null ) dfs(board,i,j,trie,res);
            }
        }
        return res;
    }
    private void dfs(char[][] board, int i, int j, Trie trie, List<String> res) {
        if ( i < 0 || i >= board.length || j < 0 || j >= board[0].length ) return;
        if ( board[i][j] == '#' || trie.next[board[i][j]-'a'] == null ) return;
        if ( trie.next[board[i][j]-'a'].word != null ) {res.add(trie.next[board[i][j]-'a'].word);trie.next[board[i][j]-'a'].word = null;}
        char tmp = board[i][j];
        board[i][j] = '#';
        dfs(board,i+1,j,trie.next[tmp-'a'],res);
        dfs(board,i-1,j,trie.next[tmp-'a'],res);
        dfs(board,i,j+1,trie.next[tmp-'a'],res);
        dfs(board,i,j-1,trie.next[tmp-'a'],res);
        board[i][j] = tmp;
    }
}