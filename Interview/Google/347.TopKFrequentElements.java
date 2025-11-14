class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for ( int n : nums ) map.put(n,map.getOrDefault(n,0)+1);
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a,b)->b[1]-a[1]);
        for ( Map.Entry<Integer,Integer> e : map.entrySet() ) maxHeap.offer(new int[]{e.getKey(),e.getValue()});
        int[] res = new int[k];
        for ( int i = 0; i < k; i++ ) res[i] = maxHeap.poll()[0];
        return res;
    }
}