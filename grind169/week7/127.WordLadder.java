class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if ( !wordList.contains(endWord) ) return 0;
        HashSet<String> set = new HashSet<>(wordList);
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        int result = 1;
        while ( !queue.isEmpty() ) {
            int size = queue.size();
            for ( int j = 0; j < size; j++ ) {
                String cur = queue.poll();
                for ( int i = 0; i < cur.length(); i++ ) {
                    char curArr[] = cur.toCharArray();
                    for ( char x = 'a'; x <= 'z'; x++ ) {
                        curArr[i] = x;
                        String tmp = new String(curArr);
                        if ( tmp.equals(endWord) ) return result+1;
                        if ( set.contains(tmp) ) {
                            queue.offer(tmp);
                            set.remove(tmp);
                        }
                    }
                }
            }
            result++;
        }
        return 0;
    }

}