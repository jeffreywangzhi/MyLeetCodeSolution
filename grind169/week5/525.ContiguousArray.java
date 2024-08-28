class Solution {
    public int findMaxLength(int[] nums) {
        int sum = 0, res = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,-1);
        for ( int i = 0; i < nums.length; i++ ) {
            int num = nums[i];
            sum += ( num << 1 ) -1;
            if ( map.containsKey(sum) ) res = Math.max(res,i-map.get(sum));
            else map.put(sum,i);
        }
        return res;
    }
}