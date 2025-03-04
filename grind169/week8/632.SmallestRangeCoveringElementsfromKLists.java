class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        List<Pair> list = new ArrayList<>();
        for ( int i = 0; i < nums.size(); i++ ) {
            List<Integer> cur = nums.get(i);
            for ( int j = 0; j < cur.size(); j++ ) {
                list.add(new Pair(cur.get(j),i));
            }
        }
        Collections.sort(list,Comparator.comparingInt(a->a.val));
        HashMap<Integer,Integer> map = new HashMap<>();
        int[] res = new int[2];
        int min = Integer.MAX_VALUE;
        int size = nums.size();
        int i = 0, j = 0;
        while ( j < list.size() ) {
            map.put(list.get(j).idx,map.getOrDefault(list.get(j).idx,0)+1);
            while ( map.size() == size ) {
                if ( list.get(j).val-list.get(i).val < min ) {
                    min = list.get(j).val-list.get(i).val;
                    res[0] = list.get(i).val;
                    res[1] = list.get(j).val;
                }
                map.put(list.get(i).idx,map.get(list.get(i).idx)-1);
                if ( map.get(list.get(i).idx) == 0 ) map.remove(list.get(i).idx);
                i++;
            }
            j++;
        }
        return res;
    }
    private class Pair {
        int val;
        int idx;
        private Pair(int val, int idx) {
            this.val = val;
            this.idx = idx;
        }
    }
}