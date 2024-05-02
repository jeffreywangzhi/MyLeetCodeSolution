class Solution {
    public int maxArea(int[] height) {
        if ( height.length == 2 ) return Math.min ( height[0], height[1] );
        int i = 0, j = height.length - 1, max = 0;
        while ( i < j ) {
            if ( Math.min( height[i], height[j] ) * ( j - i ) > max) {
                max = Math.min( height[i], height[j] ) * ( j - i) ;
            }
            if (height[i] >= height[j]) j--;
            else i++;
        }
        return max;
    }
}