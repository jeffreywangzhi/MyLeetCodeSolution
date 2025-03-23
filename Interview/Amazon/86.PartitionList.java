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
        if ( head == null ) return head;
        ListNode fake = new ListNode(-1,head);
        ListNode ph = fake, pc = head;
        ListNode g = new ListNode(-1);
        ListNode gc = g;
        while ( pc != null ) {
            if ( pc.val >= x ) {
                gc.next = pc;
                gc = gc.next;
            } else {
                ph.next = pc;
                ph = ph.next;
            }
            if ( pc.next != null ) pc = pc.next;
            else break;
        }
        ph.next = g.next;
        gc.next = null;
        return fake.next;
    }
}