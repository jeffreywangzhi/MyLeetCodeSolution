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
    public void reorderList(ListNode head) {
        ListNode slow = head, fast = head, start = head;
        while ( fast.next != null && fast.next.next != null ) {
            slow = slow.next;
            fast = fast.next.next;
        }
        Stack<ListNode> stack = new Stack<>();
        slow = slow.next;
        while ( slow != null ) {
            stack.push(slow);
            slow = slow.next;
        }
        while ( !stack.empty() ) {
            ListNode cur = stack.pop();
            cur.next = start.next;
            start.next = cur;
            start = start.next.next;
        }
        start.next = null;
    }
}