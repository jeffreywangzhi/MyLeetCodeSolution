class Trie {
    private class Node {
        boolean isWord;
        HashMap<Character,Node> child;
        private Node(boolean isWord) {
            this.isWord = isWord;
            this.child = new HashMap<>();
        }
    }
    Node root;
    public Trie() {
        root = new Node(false);
    }
    
    public void insert(String word) {
        Node cur = root;
        for ( int i = 0; i < word.length(); i++ ) {
            char c = word.charAt(i);
            if ( !cur.child.containsKey(c) ) cur.child.put(c,new Node(false));
            cur = cur.child.get(c);
        }
        cur.isWord = true;
    }
    
    public boolean search(String word) {
        Node cur = root;
        for ( int i = 0; i < word.length(); i++ ) {
            char c = word.charAt(i);
            if ( !cur.child.containsKey(c) ) return false;
            else cur = cur.child.get(c);
        }
        return cur.isWord;
    }
    
    public boolean startsWith(String prefix) {
        Node cur = root;
        for ( int i = 0; i < prefix.length(); i++ ) {
            char c = prefix.charAt(i);
            if ( !cur.child.containsKey(c) ) return false;
            else cur = cur.child.get(c);
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */