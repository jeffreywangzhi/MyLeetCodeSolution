class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        PriorityQueue<Map.Entry<Integer,Integer>> maxHeap = new PriorityQueue<>((a,b)->b.getValue()-a.getValue());
        for ( int n : nums ) map.put(n,map.getOrDefault(n,0)+1);
        for ( Map.Entry<Integer,Integer> entry : map.entrySet() ) maxHeap.offer(entry);
        List<Integer> res = new ArrayList<>();
        for ( int i = 0; i < k; i++ ) res.add(maxHeap.poll().getKey());
        int[] resArr = new int[res.size()];
        for ( int i = 0; i < resArr.length; i++ ) resArr[i] = res.get(i);
        return resArr;
    }
}