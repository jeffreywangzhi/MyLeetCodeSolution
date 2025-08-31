class Solution {
    public List<Integer> partitionLabels(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        for ( int i = 0; i < s.length(); i++ ) map.put(s.charAt(i),i);
        List<Integer> res = new ArrayList<>();
        int start = 0, max = -1;
        for ( int i = 0; i < s.length(); i++ ) {
            char c = s.charAt(i);
            max = Math.max(max,map.get(c));
            if ( i == max ) {
                res.add(i-start+1);
                start = i+1;
            }
        }
        return res;
    }
}