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
        int carry = 0;
        ListNode fake = new ListNode(-1,l2);
        ListNode pre = fake;
        while ( l1 != null || l2 != null ) {
            int v1 = l1 != null ? l1.val : 0;
            int v2 = l2 != null ? l2.val : 0;
            int sum = v1+v2+carry;
            if ( l2 == null ) {
                l2 = new ListNode(sum%10);
                pre.next = l2;   
            } else l2.val = sum%10;
            carry = sum/10;
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
            pre = pre.next;
        }
        if ( carry != 0 ) {
            l2 = new ListNode(1) ;
            pre.next = l2;
        }
        return fake.next;
    }
}