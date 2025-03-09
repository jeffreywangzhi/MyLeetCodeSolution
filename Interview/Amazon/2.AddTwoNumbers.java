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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode fake = new ListNode(-1);
        ListNode p = fake;
        int carry = 0;
        while ( l1 != null || l2 != null ) {
            int n1 = l1 != null ? l1.val : 0;
            int n2 = l2 != null ? l2.val : 0;
            p.next = new ListNode((n1+n2+carry)%10);
            p = p.next;
            carry = (n1+n2+carry)/10;
            if ( l1 != null ) l1 = l1.next;
            if ( l2 != null ) l2 = l2.next;
        }
        if ( carry != 0 ) p.next = new ListNode(carry);
        return fake.next;
    }
}