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
    public ListNode reverseList(ListNode head) {
        if ( head == null ) return head;
        ListNode dummy = new ListNode(0, head);
        ListNode cur = head;
        ListNode nxt = head.next;
        while ( nxt != null ) {
            cur.next = nxt.next;
            nxt.next = dummy.next;
            dummy.next = nxt;
            nxt = cur.next;
        }
        return dummy.next;
    }
}