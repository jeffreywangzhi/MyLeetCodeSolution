class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for ( int n : nums ) set.add(n);
        int res = 0;
        for ( int n : set ) {
            if ( set.contains(n-1) ) continue;
            int cur = 0;
            while ( set.contains(n++) ) cur++;
            res = Math.max(res,cur);
        }
        return res;
    }
}