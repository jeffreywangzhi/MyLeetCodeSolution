class Solution {
    private List<String> res;
    public List<String> findWords(char[][] board, String[] words) {
        res = new ArrayList<>();
        Trie trie = buildTrie(words);
        for ( int i = 0; i < board.length; i++ ) {
            for ( int j = 0; j < board[0].length; j++ ) {
                helper(i,j,trie,board);
            }
        }
        return res;
    }
    private void helper(int i, int j, Trie trie, char[][] board) {
        if ( i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] == '#' ) return;
        if ( trie.next[board[i][j]-'a'] == null ) return;
        if ( trie.next[board[i][j]-'a'].word != null && !res.contains(trie.next[board[i][j]-'a'].word) ) res.add(trie.next[board[i][j]-'a'].word);
        char cur = board[i][j];
        board[i][j] = '#';
        helper(i+1,j,trie.next[cur-'a'],board);
        helper(i-1,j,trie.next[cur-'a'],board);
        helper(i,j+1,trie.next[cur-'a'],board);
        helper(i,j-1,trie.next[cur-'a'],board);
        board[i][j] = cur;
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
    private class Trie {
        Trie[] next = new Trie[26];
        String word = null;
    }
}