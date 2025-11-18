class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length-1;
        while ( true ) {
            int sum = numbers[left]+numbers[right];
            if ( sum == target ) return new int[]{left+1,right+1};
            if ( sum < target ) left++;
            else right--;
        }
    }
}