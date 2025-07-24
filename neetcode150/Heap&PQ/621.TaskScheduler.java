class Solution {
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character,Integer> map = new HashMap<>();
        for ( char task : tasks ) map.put(task,map.getOrDefault(task,0)+1);
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a);
        for ( int cnt : map.values() ) pq.offer(cnt);
        Queue<int[]> queue = new LinkedList<>();
        int time = 0;
        while ( !pq.isEmpty() || !queue.isEmpty() ) {
            time++;
            while ( !queue.isEmpty() ) {
                if ( queue.peek()[1] == time ) pq.offer(queue.poll()[0]);
                else break;
            }
            if ( !pq.isEmpty() ) {
                if ( pq.peek() == 1 ) pq.poll();
                else queue.offer(new int[] {pq.poll()-1,time+n+1});
            }
        }
        return time;
    }
}