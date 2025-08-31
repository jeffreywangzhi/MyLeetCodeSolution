class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        HashSet<Integer> good = new HashSet<>();
        for ( int[] tri :  triplets ) {
            if ( tri[0] > target[0] || tri[1] > target[1] || tri[2] > target[2] ) continue;
            for ( int i = 0; i < 3; i++ ) {
                if ( tri[i] == target[i] ) good.add(i);
            }
        }
        return good.size() == 3;
    }
}