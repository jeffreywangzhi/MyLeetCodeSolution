class Solution {
    public int maxArea(int[] height) {
        int left = 0, right = height.length-1;
        int leftMax = 0, rightMax = height.length-1, res = 0;
        while ( left < right ) {
            leftMax = height[leftMax] >= height[left] ? leftMax : left;
            rightMax = height[rightMax] >= height[right] ? rightMax : right;
            res = Math.max(res,Math.min(height[leftMax],height[rightMax])*(rightMax-leftMax));
            if ( height[left] < height[right] ) left++;
            else right--;
        }
        return res;
    }
}