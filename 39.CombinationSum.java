class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<List<Integer>>> dp = new ArrayList<>(target + 1);
        for (int i = 0; i <= target; i++) {
            dp.add(new ArrayList<>());
        }
        for ( int i = 1; i <= target; i++ ) {
            List<List<Integer>> cur = new ArrayList<>();
            for ( int j = 0; j < candidates.length; j++ ) {
                if ( candidates[j] > i ) {
                    break;
                }
                if ( candidates[j] == i ) {
                    cur.add(new ArrayList<>(Arrays.asList(candidates[j])));
                    break;
                }
                int k = 0;
                int s = dp.get(i-candidates[j]).size();
                while ( s != 0 && k < s ) {
                    List<Integer> a = new ArrayList<>(dp.get(i-candidates[j]).get(k));
                    k++;
                    if ( candidates[j] > a.get(0) ) continue;
                    a.add(candidates[j]);
                    Collections.sort(a); 
                    cur.add(a);
                }
            }
            dp.set(i, cur);
        }
        return dp.get(target);
    }
}