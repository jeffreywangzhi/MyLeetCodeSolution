class Solution {
    public String alienOrder(String[] words) {
        Map<Character, Integer> degree = new HashMap<>();
        Map<Character, HashSet<Character>> map = new HashMap<>();
        for ( int i = 0; i < words.length; i++ ) {
            for ( int j = 0; j < words[i].length(); j++ ) {
                degree.put(words[i].charAt(j),0);
            }
        }
        for ( int i = 0; i < words.length-1; i++ ) {
            String cur = words[i], nxt = words[i+1];
            if ( cur.length() > nxt.length() && cur.startsWith(nxt) ) return "";
            int len = Math.min(cur.length(),nxt.length());
            for ( int j = 0; j < len; j++ ) {
                if ( cur.charAt(j) != nxt.charAt(j) ) {
                    if ( !map.containsKey(cur.charAt(j)) ) map.put(cur.charAt(j),new HashSet<>());
                    if ( map.get(cur.charAt(j)).add(nxt.charAt(j)) ) degree.put(nxt.charAt(j),degree.get(nxt.charAt(j))+1);
                    break;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        Queue<Character> q = new LinkedList<>();
        for ( char c : degree.keySet() ) {
            if ( degree.get(c) == 0 ) q.offer(c);
        }
        while ( !q.isEmpty() ) {
            char cur = q.poll();
            sb.append(cur);
            if ( !map.containsKey(cur) ) continue;
            for ( char c : map.get(cur) ) {
                degree.put(c,degree.get(c)-1);
                if ( degree.get(c) == 0 ) q.offer(c);
            }
        }
        if ( sb.length() != degree.size() ) return "";
        else return sb.toString(); 
    }
}