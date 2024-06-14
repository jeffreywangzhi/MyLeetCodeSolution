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
    public ListNode partition(ListNode head, int x) {
        ListNode res1 = new ListNode(0);
        ListNode res2 = new ListNode(0);
        ListNode p1 = head;
        ListNode p2 = res1;
        ListNode p3 = res2;
        while ( p1 != null ) {
            if ( p1.val < x ) {
                p2.next = p1;
                p2 = p2.next;
            } else {
                p3.next = p1;
                p3 = p3.next;
            }
            p1 = p1.next;
        }
        p3.next = null;
        p2.next = res2.next;
        return res1.next;
    }
}