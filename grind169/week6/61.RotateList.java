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
    public ListNode rotateRight(ListNode head, int k) {
        if ( head == null ) return head;
        int cnt = 1;
        ListNode cur = head, res = new ListNode();
        while ( cur.next != null ) {
            cur = cur.next;
            cnt++;
        }
        k = k % cnt;
        cnt -= k;
        cur.next = head;
        cur = cur.next;
        for ( int i = 1; i < cnt; i++ ) cur = cur.next;
        res = cur.next;
        cur.next = null;
        return res;
    }
}