class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for ( int num : nums ) set.add(num);
        int max = 0;
        for ( int num : set ) {
            if( !set.contains(num-1) ) {
                int cnt = 1;
                while ( set.contains(++num) ) cnt++;
                max = Math.max(max,cnt);
            }
        }
        return max;
    }
}