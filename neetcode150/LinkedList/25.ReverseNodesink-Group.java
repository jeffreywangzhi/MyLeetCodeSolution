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
        ListNode fake = new ListNode(-1,head);
        ListNode prev = fake, fast = head, slow = head;
        for ( int i = 0; i < k-1; i++ ) {
            if ( fast == null ) break;
            fast = fast.next;
        }
        if ( fast == null ) return fake.next;
        else {
            reverse(prev,slow,fast);
            slow.next = reverseKGroup(slow.next,k);
            return fake.next;
        }
    }
    private void reverse(ListNode prev, ListNode slow, ListNode fast) {
        while ( slow != fast ) {
            ListNode tmp = slow.next;
            slow.next = fast.next;
            fast.next = slow;
            slow = tmp;
        }
        prev.next = slow;
    }
}