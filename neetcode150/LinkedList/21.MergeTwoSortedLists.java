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
        ListNode res = new ListNode();
        ListNode cur = res;
        return merge(list1,list2,res,cur);
    }
    private ListNode merge(ListNode list1, ListNode list2, ListNode res, ListNode cur) {
        if ( list1 == null && list2 == null ) return res.next;
        int v1 = list1 == null ? Integer.MAX_VALUE : list1.val;
        int v2 = list2 == null ? Integer.MAX_VALUE : list2.val;
        if ( v1 <= v2 ) {
            cur.next = new ListNode(v1);
            list1 = list1.next;
        } else {
            cur.next = new ListNode(v2);
            list2 = list2.next;
        }
        cur = cur.next;
        return merge(list1,list2,res,cur);
    }
}