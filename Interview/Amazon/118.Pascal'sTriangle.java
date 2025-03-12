class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        for ( int i = 0; i < numRows; i++ ) {
            res.add(new ArrayList<>());
            res.get(i).add(1);
            for ( int j = 1; j < i; j++ ) {
                res.get(i).add(res.get(i-1).get(j-1)+res.get(i-1).get(j));
            }
            if ( i != 0 ) res.get(i).add(1);
        }
        return res;
    }
}