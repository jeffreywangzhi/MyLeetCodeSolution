class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if ( hand.length % groupSize != 0 ) return false;
        HashMap<Integer,Integer> map = new HashMap<>();
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for ( int card : hand ) {
            if ( !map.containsKey(card) ) minHeap.offer(card);
            map.put(card,map.getOrDefault(card,0)+1);
        }
        while ( !minHeap.isEmpty() ) {
            int cur = minHeap.peek();
            if ( map.get(cur) <= 0 ) {
                minHeap.poll();
                continue;
            }
            for ( int i = 0; i < groupSize; i++ ) {
                int next = cur+i;
                if ( !map.containsKey(next) || map.get(next) <= 0 ) return false;
                else map.put(next,map.get(next)-1);
            }
        }
        return true;
    }
}