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
        if ( left == right ) return head;
        ListNode fake = new ListNode(-1,head);
        ListNode l = fake, r = fake;
        while ( left > 1 || right >= -1 ) {
            if ( left-- > 1 ) l = l.next;
            if ( right-- > -1 ) r = r.next;
        }
        ListNode h = l, t = r;
        h = h.next;
        while ( h != r ) {
            ListNode tmp = h.next;
            h.next = t;
            t = h;
            h = tmp;
        }
        l.next = t;
        return fake.next;
    }
}