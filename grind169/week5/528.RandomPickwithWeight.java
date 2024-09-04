class Solution {
    TreeMap<Double,Integer> map;
    double sum;
    public Solution(int[] w) {
        map = new TreeMap<>();
        sum = 0;
        for ( int i = 0; i < w.length; i++ ) {
            sum+=w[i];
            map.put(sum,i);
        } 
    }
    
    public int pickIndex() {
        Random ran = new Random();
        double in = ran.nextDouble(sum);
        return map.get(map.ceilingKey(in));
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */