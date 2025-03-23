class Solution {
    public String reverseWords(String s) {
        s = s.trim();
        String[] str = s.split(" ");
        StringBuilder res = new StringBuilder();
        for ( int i = str.length-1; i >= 0; i-- ) {
            String a = str[i];
            if ( a.isBlank() || a.isEmpty() ) continue;
            else res.append(a).append(" ");
        }
        res.deleteCharAt(res.length()-1);
        return res.toString();
    }
}