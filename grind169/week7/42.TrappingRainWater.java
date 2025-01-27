class Solution {
    public int trap(int[] height) {
        int left = 0, right = height.length-1;
        int leftMax =0, rightMax = 0, res = 0;
        while ( left < right ) {
            if ( height[left] < height[right] ) {
                leftMax = Math.max(leftMax,height[left]);
                res += leftMax-height[left];
                left++;
            } else {
                rightMax = Math.max(rightMax,height[right]);
                res += rightMax-height[right];
                right--;
            }
        }
        return res;
    }
}