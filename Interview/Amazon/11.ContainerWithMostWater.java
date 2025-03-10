class Solution {
    public int maxArea(int[] height) {
        int res = 0;
        int leftHigh = 0, rightHigh = height.length-1;
        int left = 0, right = height.length-1;
        while ( left < right ) {
            leftHigh = height[leftHigh] >= height[left] ? leftHigh : left;
            rightHigh = height[rightHigh] >= height[right] ? rightHigh : right;
            res = Math.max(res,Math.min(height[leftHigh],height[rightHigh]) * (rightHigh-leftHigh));
            if ( height[left] < height[right] ) left++;
            else right--;
        }
        return res;
    }
}