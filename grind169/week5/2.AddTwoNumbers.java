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
        ListNode res = new ListNode();
        ListNode p1 = l1, p2 = l2, p3 = res;
        int carry = 0, sum = 0;
        while ( p1 != null || p2 != null ) {
            int a = p1 != null ? p1.val : 0;
            int b = p2 != null ? p2.val : 0;
            sum = a+b+carry;
            p3.next = new ListNode(sum%10);
            p3 = p3.next;
            carry = sum/10;
            p1 = p1 != null ? p1.next : null ;
            p2 = p2 != null ? p2.next : null ;
        }
        if ( carry != 0 ) p3.next = new ListNode(carry);
        return res.next;
    }
}