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
        ListNode tmp;
        for ( ListNode n : lists ) {
            while ( n != null ) {
                pq.offer(new ListNode(n.val));
                n = n.next;
            }
        }
        ListNode fake = new ListNode(-1);
        ListNode p = fake;
        while ( !pq.isEmpty() ) {
            p.next = pq.poll();
            p = p.next;
        }
        return fake.next;
    }
}