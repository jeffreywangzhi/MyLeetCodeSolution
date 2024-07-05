class Trie {
    public class Node {
        private boolean isWord;
        private HashMap<Character,Node> child;
        public Node() {
            isWord = false;
            child = new HashMap<Character,Node>();
        }
    }
    Node start;
    public Trie() {
        start = new Node();
    }
    
    public void insert(String word) {
        Node head = start;
        for ( int i = 0; i < word.length(); i++ ) {
            if ( !head.child.containsKey(word.charAt(i)) ) head.child.put(word.charAt(i), new Node());
            head = head.child.get(word.charAt(i));
        }
        head.isWord = true;
    }
    
    public boolean search(String word) {
        Node head = start;
        for ( int i = 0; i < word.length(); i++ ) {
            if ( !head.child.containsKey(word.charAt(i)) ) return false;
            else head = head.child.get(word.charAt(i));
        }
        return head.isWord;
    }
    
    public boolean startsWith(String prefix) {
        Node head = start;
        for ( int i = 0; i < prefix.length(); i++ ) {
            if ( !head.child.containsKey(prefix.charAt(i)) ) return false;
            else head = head.child.get(prefix.charAt(i));
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