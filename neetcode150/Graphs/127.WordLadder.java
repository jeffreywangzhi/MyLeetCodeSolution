class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> set = new HashSet<>(wordList);
        if ( !set.contains(endWord) ) return 0;
        set.remove(beginWord);
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        int res = 1;
        while ( !queue.isEmpty() ) {
            int size = queue.size();
            for ( int i = 0; i < size; i++ ) {
                String cur = queue.poll();
                for ( int j = 0; j < cur.length(); j++ ) {
                    for ( char c = 'a'; c <= 'z'; c++ ) {
                        char[] ch = cur.toCharArray();
                        ch[j] = c;
                        String tmp = new String(ch);
                        if ( tmp.equals(endWord) ) return res+1;
                        if ( set.contains(tmp) ) {
                            queue.offer(tmp);
                            set.remove(tmp);
                        }
                    }
                }
            }
            res++;
        }
        return 0;
    }
}