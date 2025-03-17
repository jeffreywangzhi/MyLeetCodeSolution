class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a);
        int i = 0;
        for ( ; i < heights.length-1; i++ ) {
            int diff = heights[i+1]-heights[i];
            if ( diff > 0 ) {
                pq.offer(diff);
                if ( bricks < diff ) {
                    if ( ladders <= 0 ) return i;
                    bricks += pq.poll()-diff;
                    ladders--;
                } else bricks -= diff;
            }
        }
        return i;
    }
}