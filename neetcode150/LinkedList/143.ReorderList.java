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
    public void reorderList(ListNode head) {
        ListNode p1 = head, p2 = head;
        while ( p2 != null && p2.next != null ) {
            p1 = p1.next;
            p2 = p2.next.next;
        }
        ListNode prev = null;
        ListNode cur = p1;
        while ( cur != null ) {
            ListNode tmp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = tmp;
        }
        ListNode p3 = head, p4 = prev;
        while ( p3 != p1 ) {
            ListNode tmp = p4.next;
            p4.next = p3.next;
            p3.next = p4;
            p3 = p3.next.next;
            p4 = tmp;
        }
        p3.next = null;
    }
}