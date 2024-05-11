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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if ( head.next == null ) return null;
        ListNode res = new ListNode(0, head);
        ListNode p = res;
        int count = 0;
        while ( head != null ) {
            if ( count < n ) {
                head = head.next;
                count++;
            }else {
                head = head.next;
                p = p.next;
            }
        }
        p.next = p.next.next;
        return res.next;
    }
}