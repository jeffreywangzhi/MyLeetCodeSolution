class Solution {
    public int maxChunksToSorted(int[] arr) {
        int reach = 0, res = 0;
        for ( int i = 0; i < arr.length; i++ ) {
            reach = Math.max(reach,arr[i]);
            if ( i == reach ) res++;
        }
        return res;
    }
}