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
    public ListNode sortList(ListNode head) {
        if ( head == null || head.next == null ) return head;
        ListNode mid = getMiddle(head);
        ListNode next = mid.next;
        mid.next = null;
        return merge(sortList(head),sortList(next));
    }
    public ListNode getMiddle(ListNode head) {
        ListNode slow = head, fast = head;
        while ( fast.next != null && fast.next.next != null ) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    public ListNode merge(ListNode a, ListNode b) {
        ListNode fake = new ListNode(-1);
        ListNode fakep = fake;
        while ( a != null && b != null ) {
            if ( a.val < b.val ) {
                fakep.next = a;
                a = a.next;
            } else {
                fakep.next = b;
                b = b.next;
            }
            fakep = fakep.next;
        }
        if ( a != null ) fakep.next = a;
        if ( b != null ) fakep.next = b;
        return fake.next;
    }
}