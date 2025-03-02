/*
// Definition for an Interval.
class Interval {
    public int start;
    public int end;

    public Interval() {}

    public Interval(int _start, int _end) {
        start = _start;
        end = _end;
    }
};
*/

class Solution {
    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        PriorityQueue<Interval> pq = new PriorityQueue<>(
            (a,b)->a.start != b.start ? a.start-b.start : a.end-b.end
        );
        for ( List<Interval> interval : schedule ) {
            for ( Interval intervals : interval ) {
                pq.offer(intervals);
            }
        } 
        Stack<Interval> stack = new Stack<>();
        List<Interval> res = new ArrayList<>();
        stack.push(pq.poll());
        while ( !pq.isEmpty() ) {
            Interval cur = pq.poll();
            if ( cur.start <= stack.peek().end ) {
                Interval tmp = stack.pop();
                stack.push(new Interval(cur.start,Math.max(tmp.end,cur.end)));
            } else {
                res.add(new Interval(stack.peek().end,cur.start));
                stack.push(cur);
            }
            
        }
        return res;
    }
}