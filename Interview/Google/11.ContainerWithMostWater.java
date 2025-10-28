class Solution {
    public int maxArea(int[] height) {
        int left = 0, right = height.length-1;
        int leftMax = 0, rightMax = height.length-1;
        int res = 0;
        while ( left < right ) {
            leftMax = height[left] > height[leftMax] ? left : leftMax;
            rightMax = height[right] > height[rightMax] ? right : rightMax;
            res = Math.max(res,Math.min(height[leftMax],height[rightMax])*(rightMax-leftMax));
            if ( height[leftMax] > height[rightMax] ) right--;
            else left++;
        }
        return res;
    }
}