class Solution {
    public String mergeAlternately(String word1, String word2) {
        int p1 = 0, p2 = 0;
        StringBuilder res = new StringBuilder();
        while ( p1 < word1.length() || p2 < word2.length() ) {
            String w1 = p1 < word1.length() ? String.valueOf(word1.charAt(p1)) : "";
            String w2 = p2 < word2.length() ? String.valueOf(word2.charAt(p2)) : "";
            res.append(w1).append(w2);
            p1++;p2++;
        }
        return res.toString();
    }
}