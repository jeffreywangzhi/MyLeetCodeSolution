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
        Node cur = head;
        while ( cur != null ) {
            map.put(cur,new Node(cur.val));
            cur = cur.next;
        }
        cur = head;
        Node fake = new Node(-1);
        Node p = fake;
        while ( cur != null ) {
            p.next = map.get(cur);
            p = p.next;
            p.random = map.get(cur.random);
            cur = cur.next;
        }
        return fake.next;
    }
}