class Solution {
    public int[] platesBetweenCandles(String s, int[][] queries) {
        int[] last = new int[s.length()];
        int[] next = new int[s.length()];
        int[] presum = new int[s.length()];

        int pre = -1;
        for ( int i = 0; i < s.length(); i++ ) {
            if ( s.charAt(i) =='|' ) pre = i;
            last[i] = pre;
        }
        pre = -1;
        for ( int i = s.length()-1; i >= 0; i-- ) {
            if ( s.charAt(i) =='|' ) pre = i;
            next[i] = pre;
        }
        pre = 0;
        for ( int i = 0; i < s.length(); i++ ) {
            if ( s.charAt(i) == '*' ) pre++;
            presum[i] = pre;
        }
        int[] res = new int[queries.length];
        for ( int i = 0; i < queries.length; i++ ) {
            int l = last[queries[i][1]];
            int n = next[queries[i][0]];
            if ( l < queries[i][0] || n > queries[i][1] ) res[i] = 0;
            else res[i] = presum[l]-presum[n];
        }
        return res;
    }
}