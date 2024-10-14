class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character,Integer> map = new HashMap<>();
        for ( char ch : t.toCharArray() ) map.put(ch,map.getOrDefault(ch,0)+1);
        int left = 0, right = 0, cnt = 0;
        String res = s;
        int slen = s.length();
        int tlen = t.length();
        for ( ; right < slen; right++ ) {
            char r = s.charAt(right);
            if ( map.containsKey(r) ) {
                if ( map.get(r) > 0 ) cnt++;
                map.put(r,map.get(r)-1);
            }
            while ( left < right ) {
                char l = s.charAt(left);
                if ( map.containsKey(l) ) {
                    if ( map.get(l) >= 0 ) break;
                    else {
                        map.put(l,map.get(l)+1);
                    }
                }
                left++;
            }
            if ( cnt == tlen && s.substring(left,right+1).length() < res.length() ) res = s.substring(left,right+1);
        }
        return (slen >= res.length() && cnt == tlen) ? res : "";
        
    }
}