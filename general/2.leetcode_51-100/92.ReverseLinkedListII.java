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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode fake = new ListNode(-1);
        fake.next = head;
        ListNode p0 = fake;
        ListNode p1 = new ListNode(0);
        for ( int i = 0; i < left-1; i++ ) p0 = p0.next;
        p1 = p0.next;
        for ( int i = left; i < right; i++ ) {
            ListNode temp = p1.next;
            p1.next = temp.next;
            temp.next = p0.next;
            p0.next = temp;
        }
        return fake.next;
    }
}