/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        HashMap<Node,Node> map = new HashMap<>();
        Node h = head;
        Node prev = new Node(-1);
        while ( h != null ) {
            prev.next = new Node(h.val);
            prev = prev.next;
            map.put(h,prev);
            h = h.next;
        }
        h = head;
        Node cur = map.get(head);
        while ( h != null ) {
            cur.random = map.get(h.random);
            cur = cur.next;
            h = h.next;
        }
        return map.get(head);

    }
}