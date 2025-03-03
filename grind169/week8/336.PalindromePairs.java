class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        HashMap<String,Integer> wordMap = new HashMap<>();
        Set<Integer> set = new TreeSet<>();
        for ( int i = 0; i < words.length; i++ ) {
            wordMap.put(words[i],i);
            set.add(words[i].length());
        }
        List<List<Integer>> res = new ArrayList<>();
        for ( int i = 0; i < words.length; i++ ) {
            String rev = new StringBuilder(words[i]).reverse().toString();
            int revLen = rev.length();
            if ( wordMap.containsKey(rev) && wordMap.get(rev) != i ) res.add(new ArrayList<>(Arrays.asList(i,wordMap.get(rev))));
            for ( int len : set ) {
                if ( len == revLen ) break;
                if ( isPalindrome(rev,0,revLen-len-1) ) {
                    String s = rev.substring(revLen-len);
                    if ( wordMap.containsKey(s) ) res.add(new ArrayList<>(Arrays.asList(i,wordMap.get(s))));
                }
                if ( isPalindrome(rev,len,revLen-1) ) {
                    String s = rev.substring(0,len);
                    if ( wordMap.containsKey(s) ) res.add(new ArrayList<>(Arrays.asList(wordMap.get(s),i)));
                }
            }
        }
        return res;
    }
    private boolean isPalindrome(String word, int start, int end) {
        while ( start < end ) {
            if ( word.charAt(start++) != word.charAt(end--) ) return false;
        }
        return true;
    }
}