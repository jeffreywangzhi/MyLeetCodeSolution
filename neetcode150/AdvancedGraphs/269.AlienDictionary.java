class Solution {
    private HashMap<Character,HashSet<Character>> adj;
    private HashSet<Character> visited;
    private HashSet<Character> visiting;
    private StringBuilder str;
    public String alienOrder(String[] words) {
        adj = new HashMap<>();
        visited = new HashSet<>();
        visiting = new HashSet<>();
        str = new StringBuilder();
        for ( String s : words ) {
            for ( char c : s.toCharArray() ) adj.putIfAbsent(c,new HashSet<>());
        }
        for ( int i = 0; i < words.length-1; i++ ) {
            String w1 = words[i];
            String w2 = words[i+1];
            int minLen = w1.length() < w2.length() ? w1.length() : w2.length();
            int j = 0;
            for ( ; j < minLen; j++ ) {
                if ( w1.charAt(j) != w2.charAt(j) ) {
                    adj.get(w1.charAt(j)).add(w2.charAt(j));
                    break;
                }
            }
            if ( j == minLen && w1.length() > w2.length() ) return "";
        }
        for ( char c : adj.keySet() ) {
            if ( !visited.contains(c) ) {
                if ( !postOrder(c) ) return "";
            }
        }
        return str.reverse().toString();
    }
    private boolean postOrder(char c) {
        if ( visited.contains(c) ) return true;
        if ( visiting.contains(c) ) return false;
        visiting.add(c);
        for ( char nei : adj.get(c) ) {
            if ( !postOrder(nei) ) return false;
        }
        visiting.remove(c);
        visited.add(c);
        str.append(c);
        return true;
    }
}