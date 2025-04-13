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
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;
        ListNode res = new ListNode(-1);
        res.next = merge(lists,0,lists.length-1);
        return res.next;
    }
    private ListNode merge(ListNode[] lists, int start, int end) {
        if ( start == end ) return lists[end];
        int mid = start+(end-start)/2;
        ListNode l1 = merge(lists,start,mid);
        ListNode l2 = merge(lists,mid+1,end);
        return sort(l1,l2);
    }
    private ListNode sort(ListNode l1, ListNode l2) {
        if ( l1 == null && l2 == null ) return null;
        if ( l1 == null || l2 == null ) return l1 == null ? l2 : l1;
        if ( l1.val < l2.val ) {
            l1.next = sort(l1.next,l2);
            return l1;
        } else {
            l2.next = sort(l1,l2.next);
            return l2;
        }
    }
}