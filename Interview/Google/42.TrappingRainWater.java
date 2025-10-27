class Solution {
    public int trap(int[] height) {
        int left = 0, right = height.length-1;
        int leftMax = height[left], rightMax = height[right];
        int res = 0;
        while ( left < right ) {
            leftMax = Math.max(leftMax,height[left]);
            rightMax = Math.max(rightMax,height[right]);
            if ( leftMax <= rightMax ) res += leftMax-height[left++];
            else res += rightMax-height[right--];
        }
        return res;
    }
}