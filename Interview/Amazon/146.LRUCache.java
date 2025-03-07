class LRUCache {

    class Node {
        int key;
        int val;
        Node prev;
        Node next;
        private Node(int key, int val) {
            this.key = key;
            this.val = val;
            this.prev = null;
            this.next = null;
        }
    }

    private Node oldest;
    private Node latest;
    private HashMap<Integer,Node> map;
    private int cap;

    public LRUCache(int capacity) {
        oldest = new Node(-1,-1);
        latest = new Node(-1,-1);
        oldest.next = latest;
        latest.prev = oldest;
        map = new HashMap<>();
        cap = capacity;
    }
    
    public int get(int key) {
        if ( !map.containsKey(key) ) return -1;
        Node cur = map.get(key);
        rmNode(cur);
        addTail(cur);
        return map.get(key).val;
    }
    
    public void put(int key, int value) {
        if ( map.containsKey(key) ) {
            Node cur = map.get(key);
            cur.val = value;
            rmNode(cur);
            addTail(cur);
        } else {
            if ( map.size() >= cap ) map.remove(rmHead());
            Node add = new Node(key,value);
            addTail(add);
            map.put(key,add);
        }
    }
    private void rmNode(Node cur) {
        cur.prev.next = cur.next;
        cur.next.prev = cur.prev;
    }
    private int rmHead() {
        int k = oldest.next.key;
        oldest.next = oldest.next.next;
        oldest.next.prev = oldest;
        return k;
    }
    private void addTail(Node cur) {
        cur.prev = latest.prev;
        cur.next = latest;
        cur.prev.next = cur;
        latest.prev = cur;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */