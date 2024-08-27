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
    public ListNode oddEvenList(ListNode head) {
        if ( head == null ) return head;
        ListNode p1 = head, p2h = head.next, p2 = head.next;
        while ( p2 != null && p2.next != null ) {
            p1.next = p2.next;
            p2.next = p2.next.next;
            p1 = p1.next;
            p2 = p2.next;
        }
        p1.next = p2h;
        return head;
    }
}