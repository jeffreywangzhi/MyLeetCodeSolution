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
    public boolean isPalindrome(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        ListNode fast = head, slow = head;
        while ( fast != null && fast.next != null ) {
            stack.push(slow.val);
            fast = fast.next.next;
            slow = slow.next;
        }
        if ( fast != null ) slow = slow.next;
        while ( slow != null ) {
            if ( stack.empty() ) return false;
            if ( stack.pop() != slow.val ) return false;
            slow = slow.next;
        }
        return stack.empty();
    }
}