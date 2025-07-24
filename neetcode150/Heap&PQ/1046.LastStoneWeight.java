class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a);
        for ( int stone : stones ) pq.offer(stone);        
        while ( pq.size() > 1 ) {
            int s1 = pq.poll();
            int s2 = pq.poll();
            int rem = s1-s2;
            if ( rem > 0 ) pq.offer(rem);
        }
        return !pq.isEmpty() ? pq.peek() : 0;
    }
}