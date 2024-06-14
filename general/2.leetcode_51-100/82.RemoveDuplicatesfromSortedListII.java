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
    public ListNode deleteDuplicates(ListNode head) {
        if ( head == null ) return head;
        ListNode res = new ListNode(0);
        ListNode resp = res;
        ListNode p1 = head;
        ListNode p2 = head.next;
        boolean flag = false;
        while ( p2 != null || ( p2 == null && !flag ) ) {
            if ( p2 == null && !flag ) {
                resp.next = new ListNode(p1.val);
                flag = true;
            } else if ( p1.val == p2.val ) {
                p1 = p1.next;
                p2 = p2.next;
                flag = true;
            } else {
                if ( !flag ) {
                    resp.next = new ListNode(p1.val);
                    resp = resp.next;
                }
                p1 = p1.next;
                p2 = p2.next;
                flag = false;
            }
        }
        return res.next;
    }
}