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
        ListNode prev = null;
        return reverse(head,prev);
    }
    private ListNode reverse(ListNode head, ListNode prev) {
        if ( head == null ) return prev;
        ListNode nxt = head.next;
        head.next = prev;
        prev = head;
        return reverse(nxt,prev);
    }
}