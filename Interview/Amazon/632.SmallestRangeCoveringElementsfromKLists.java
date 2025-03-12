class Solution {
    private class Pair {
        int val;
        int idx;
        private Pair(int val, int idx) {
            this.val = val;
            this.idx = idx;
        }
    }
    public int[] smallestRange(List<List<Integer>> nums) {
        List<Pair> list = new ArrayList<>();
        for ( int i = 0; i < nums.size(); i++ ) {
            for ( int j = 0; j < nums.get(i).size(); j++ ) list.add(new Pair(nums.get(i).get(j),i));
        }
        Collections.sort(list,Comparator.comparingInt(a->a.val));
        HashMap<Integer,Integer> map = new HashMap<>();
        int i = 0, j = 0, gap = Integer.MAX_VALUE;
        int[] res = new int[2];
        for ( ; j < list.size(); j++ ) {
            map.put(list.get(j).idx,map.getOrDefault(list.get(j).idx,0)+1);
            if ( map.size() < nums.size() ) continue;
            while ( map.size() >= nums.size() ) {
                if ( gap > list.get(j).val-list.get(i).val ) {
                    res[0] = list.get(i).val;
                    res[1] = list.get(j).val;
                    gap = res[1]-res[0];
                }
                if ( map.get(list.get(i).idx) > 1 ) {
                    map.put(list.get(i).idx,map.get(list.get(i).idx)-1);
                    i++;
                } else break;
            }
        }
        return res;
    }
}