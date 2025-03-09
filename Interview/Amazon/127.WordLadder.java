class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> set = new HashSet<>(wordList);
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        int res = 1;
        while ( !queue.isEmpty() ) {
            int size = queue.size();
            for ( int i = 0; i < size; i++ ) {
                String cur = queue.poll();
                for ( int j = 0; j < cur.length(); j++ ) {
                    for ( char c = 'a'; c <= 'z'; c++ ) {
                        char[] tmp = cur.toCharArray();
                        tmp[j] = c;
                        String s = new String(tmp);
                        if ( set.contains(s) ) {
                            if ( s.equals(endWord) ) return res+1;
                            queue.offer(s);
                            set.remove(s);
                        }
                    }
                }
            }
            res++;
        }
        return 0;

    }
}