class Solution {
    public class Pair {
        char key;
        int val;
        private Pair (char key, int val) {
            this.key = key;
            this.val = val;
        }
    }
    public String reorganizeString(String s) {
        int max = s.length()%2 == 0 ? s.length()/2 : s.length()/2+1;
        HashMap<Character,Integer> map = new HashMap<>();
        for ( int i = 0; i < s.length(); i++ ) map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->b.val-a.val);
        for ( Map.Entry<Character,Integer> entry : map.entrySet() ) pq.offer(new Pair(entry.getKey(),entry.getValue()));
        if ( pq.peek().val > max ) return "";
        StringBuilder res = new StringBuilder();
        while ( pq.size() > 1 ) {
            Pair cur = pq.poll(), nxt = pq.poll();
            res.append(cur.key).append(nxt.key);
            if (--cur.val > 0) pq.offer(cur);
            if (--nxt.val > 0) pq.offer(nxt);
        }
        if ( pq.size() == 1 ) res.append(pq.poll().key);
        return res.toString();
    }
}