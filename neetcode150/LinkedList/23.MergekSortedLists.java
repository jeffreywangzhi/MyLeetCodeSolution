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
        if ( lists.length == 0 ) return null;
        ListNode res = new ListNode(-1);
        res.next = merge(lists,0,lists.length-1);
        return res.next;
    }
    private ListNode merge(ListNode[] lists, int start, int end) {
        if ( start == end ) return lists[end];
        int mid = start+(end-start)/2;
        ListNode left = merge(lists,start,mid);
        ListNode right = merge(lists,mid+1,end);
        return sort(left,right);
    }
    private ListNode sort(ListNode l1, ListNode l2) {
        ListNode fake = new ListNode(-1,l1);
        ListNode cur = fake;
        while ( l1 != null || l2 != null ) {
            int v1 = l1 != null ? l1.val : Integer.MAX_VALUE;
            int v2 = l2 != null ? l2.val : Integer.MAX_VALUE;
            if ( v1 <= v2 ) {
                cur.next = l1;
                l1 = l1.next;
            }else {
                cur.next = l2;
                l2 = l2.next;
            } 
            cur = cur.next;
        }
        return fake.next;
    }
}