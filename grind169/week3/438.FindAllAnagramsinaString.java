class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        char[] parr = p.toCharArray();
        Arrays.sort(parr);
        for ( int i = 0; i <= s.length()-p.length(); i++ ) {
            String cur = s.substring(i,i+p.length());
            char[] carr = cur.toCharArray();
            Arrays.sort(carr);
            if ( Arrays.equals(parr,carr) ) res.add(i);
        }
        return res;
    }
}