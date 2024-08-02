class WordDictionary {
    public class Node {
        private boolean isWord;
        private HashMap<Character,Node> child;
        public Node() {
            isWord = false;
            child = new HashMap<Character,Node>();
        }
    }
    Node start;
    public WordDictionary() {
        start = new Node();
    }
    
    public void addWord(String word) {
        Node head = start;
        for ( int i = 0; i < word.length(); i++ ) {
            if ( !head.child.containsKey(word.charAt(i)) ) head.child.put(word.charAt(i),new Node());
            head = head.child.get(word.charAt(i));
        }
        head.isWord = true;
    }
    
    public boolean search(String word) {
        return searchWord(word,start,0);
    }

    public boolean searchWord(String word, Node p, int i) {
        if ( i == word.length() ) return p.isWord;
        if ( word.charAt(i) == '.' ) {
            for ( Map.Entry<Character,Node> entry : p.child.entrySet() ) {
                if ( entry != null && searchWord(word,entry.getValue(),i+1) ) return true;
            }
            return false;
        } else {
            if ( p == null || !p.child.containsKey(word.charAt(i)) ) return false;
            return p.child.get(word.charAt(i)) != null && searchWord(word,p.child.get(word.charAt(i)),i+1);
        }
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */