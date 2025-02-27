/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b)->a.val-b.val);
        for ( int i = 0; i < lists.length; i++ ) {
            ListNode cur = lists[i];
            while ( cur != null ) {
                ListNode tmp = new ListNode(cur.val);
                pq.offer(tmp);
                cur = cur.next;
            }
        }
        ListNode p = pq.poll();
        ListNode res = p;
        while ( !pq.isEmpty() ) {
            p.next = pq.poll();
            p = p.next;
        }
        return res;
    }
}