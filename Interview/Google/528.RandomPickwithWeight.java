class Solution {
    int[] sum;
    public Solution(int[] w) {
        sum = w;
        for ( int i = 1; i < sum.length; i++ ) sum[i] = sum[i]+sum[i-1];
    }
    
    public int pickIndex() {
        double target = Math.random() * sum[sum.length-1];
        int start = 0, end = sum.length;
        while ( start < end ) {
            int mid = start+(end-start)/2;
            if ( sum[mid] < target ) start = mid+1;
            else end = mid;
        }
        return end;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */