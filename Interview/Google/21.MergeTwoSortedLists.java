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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode fake = new ListNode();
        ListNode p = fake;
        while ( list1 != null || list2 != null ) {
            int n1 = list1 != null ? list1.val : Integer.MAX_VALUE;
            int n2 = list2 != null ? list2.val : Integer.MAX_VALUE;
            if ( n1 <= n2 ) {
                p.next = list1;
                list1 = list1.next;
            } else {
                p.next = list2;
                list2 = list2.next;
            }
            p = p.next;
        }
        return fake.next;
    }
}



