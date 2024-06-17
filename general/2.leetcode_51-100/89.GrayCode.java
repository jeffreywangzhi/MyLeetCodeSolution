class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> list = new ArrayList<>();
        list.add(0);
        for ( int i = 0; i < n; i++ ) {
            for ( int j = list.size()-1; j >= 0; j-- ) {
                list.add(list.get(j) | 1 << i);
            }
        }
        return list;
    }
}