class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String,Integer> map = new HashMap<>();
        for ( String word : words ) map.put(word,map.getOrDefault(word,0)+1);
        PriorityQueue<Map.Entry<String,Integer>> pq = new PriorityQueue<>((a,b)->a.getValue()!=b.getValue()?a.getValue()-b.getValue():b.getKey().compareTo(a.getKey()));
        for ( Map.Entry<String,Integer> entry : map.entrySet() ) {
            if ( pq.size() < k ) pq.offer(entry);
            else if ( pq.peek().getValue() < entry.getValue() ) {pq.poll();pq.offer(entry);}
            else if ( pq.peek().getValue() == entry.getValue() ) {pq.offer(entry);pq.poll();}
        }
        List<String> res = new ArrayList<>();
        while ( !pq.isEmpty() ) res.add(0,pq.poll().getKey());
        return res;
    }
}