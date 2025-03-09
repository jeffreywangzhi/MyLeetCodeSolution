class Solution {
    private class Pair {
        int val;
        int cnt;
        private Pair (int val, int cnt) {
            this.val = val;
            this.cnt = cnt;
        }
    }
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for ( int num : nums ) map.put(num,map.getOrDefault(num,0)+1);
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->b.cnt-a.cnt);
        for ( Map.Entry<Integer,Integer> entry : map.entrySet() ) pq.offer(new Pair(entry.getKey(),entry.getValue()));
        int[] res = new int[k];
        for ( int i = 0; i < k; i++ ) res[i] = pq.poll().val;
        return res;
    }
}