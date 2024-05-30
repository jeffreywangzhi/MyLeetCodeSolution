class Solution {
    public String convert(String s, int numRows) {
        // exceptions
        if ( s.length() == 1 || numRows == 1){
            return s;
        }
        // build arraylists
        int idx = 0, d = 1;
        List<Character>[] rows = new ArrayList[numRows];
        for ( int i = 0 ; i < numRows ; i ++ ){
            rows[i] = new ArrayList<>();
        }
        // first for loop
        for ( int i = 0 ; i < s.length() ; i ++ ){
            rows[idx].add(s.charAt(i));
            if ( idx == 0 ) {
                d = 1;
            }else if (idx == numRows - 1){
                d = -1;
            }
            idx += d;
        }
        // string builder
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
           for (int j = 0; j < rows[i].size(); j++) {
               char c = rows[i].get(j);
               result.append(c);
           }
        }
        return result.toString();
    }
}