class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        HashMap<String,PriorityQueue<String>> adj = new HashMap<>();
        for ( List<String> t : tickets ) adj.computeIfAbsent(t.get(0),k->new PriorityQueue<>()).offer(t.get(1));
        LinkedList<String> res = new LinkedList<>();
        visit("JFK",adj,res);
        return res;
    }
    private void visit(String cur, HashMap<String,PriorityQueue<String>> adj, LinkedList<String> res) {
        if ( adj.containsKey(cur) ) {
            PriorityQueue<String> pq = adj.get(cur);
            while ( !pq.isEmpty() ) {
                visit(pq.poll(),adj,res);
            }
        }
        res.addFirst(cur);
    }
}