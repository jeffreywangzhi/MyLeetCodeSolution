class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        int cur = 0, res = 0;
        for ( int n : nums ) {
            cur += n;
            if ( map.containsKey(cur-k) ) res += map.get(cur-k);
            map.put(cur,map.getOrDefault(cur,0)+1);
        }
        return res;
    }
}