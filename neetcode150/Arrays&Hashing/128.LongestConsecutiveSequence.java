class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for ( int num : nums ) set.add(num);
        int res = 0;
        for ( int num : set ) {
            if ( set.contains(num-1) ) continue;
            int cur = 1;
            while ( set.contains(++num) ) cur++;
            res = Math.max(res,cur);
        }
        return res;
    }
}