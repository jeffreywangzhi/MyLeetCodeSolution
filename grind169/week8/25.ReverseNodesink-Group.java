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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode p = head;
        for ( int i = 0; i < k; i++ ) {
            if ( p == null ) return head;
            p = p.next;
        }
        ListNode cur = reverse(head,p,k);
        head.next = reverseKGroup(p,k);
        return cur;

    }
    private ListNode reverse(ListNode start, ListNode end, int k) {
        ListNode prev = end;
        while ( start != end ) {
            ListNode tmp = start.next;
            start.next = prev;
            prev = start;
            start = tmp;
        }
        return prev;
    }
}