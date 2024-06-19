class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        String cur = "";
        solve(s, 0, cur, res);
        return res; 
    }
    private void solve(String s, int idx, String cur, List<String> res) {
        if ( s.isEmpty() && idx == 4 ) {res.add(cur.substring(0,cur.length()-1)); return;}
        if ( s.length() / (4.0 - idx) > 3 ) return;
        for ( int i = 1; i < 4; i++ ) {
            if ( i > s.length() ) return;
            if ( Integer.valueOf(s.substring(0,i)) > 255 || ( i != 1 && s.charAt(0) == '0' ) ) continue;
            cur += ( s.substring(0,i) + "." );
            solve(s.substring(i), idx+1, cur, res);
            String[] temp2 = cur.split("\\.");
            cur = cur.substring(0, cur.length() - (temp2[temp2.length-1].length()+1));
        }
    }
}