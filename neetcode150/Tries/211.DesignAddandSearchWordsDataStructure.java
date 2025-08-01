class WordDictionary {
    private class Node {
        Node[] child;
        boolean isWord;
        private Node(boolean isWord) {
            this.child = new Node[26];
            this.isWord = isWord;
        }
    }
    Node root;
    public WordDictionary() {
        root = new Node(false);
    }
    
    public void addWord(String word) {
        Node cur = root;
        for ( int i = 0; i < word.length(); i++ ) {
            int c = word.charAt(i)-'a';
            if ( cur.child[c] == null ) cur.child[c] = new Node(false);
            cur = cur.child[c];
        }
        cur.isWord = true;
    }
    
    private boolean dfs(String word, Node cur, int idx) {
        if ( idx == word.length() ) return cur.isWord;
        char c = word.charAt(idx);
        if ( c == '.' ) {
            for ( int i = 0; i < 26; i++ ) {
                if ( cur.child[i] != null ) {
                    if ( dfs(word,cur.child[i],idx+1) == true ) return true;
                } else continue;
            }
            return false;
        } else {
            if ( cur.child[c-'a'] == null ) return false;
            else return dfs(word,cur.child[c-'a'],idx+1);
        }
    }

    public boolean search(String word) {
        return dfs(word,root,0);
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */