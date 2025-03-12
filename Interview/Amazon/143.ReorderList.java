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
        ListNode fast = head, slow = head;
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
        ListNode p = head;
        while ( !stack.isEmpty() ) {
            ListNode tmp = stack.pop();
            tmp.next = p.next;
            p.next = tmp;
            p = p.next.next;
        }
        p.next = null;
    }
}