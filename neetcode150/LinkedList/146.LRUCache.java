class LRUCache {
    private class Node {
        Node next;
        Node prev;
        int key;
        int val;
        private Node(int key, int val) {
            this.key = key;
            this.val = val;
            next = null;
            prev = null;
        }
    }
    HashMap<Integer,Node> map;
    private Node oldest;
    private Node latest;
    int capacity;
    int count;
    public LRUCache(int capacity) {
        map = new HashMap<>();
        oldest = new Node(-1,-1);
        latest = new Node(-1,-1);
        oldest.next = latest;
        latest.prev = oldest;
        this.capacity = capacity;
        this.count = 0;
    }
    
    public int get(int key) {
        if ( !map.containsKey(key) ) return -1;
        pullNode(key);
        addLatest(key,map.get(key).val);
        return map.get(key).val;
    }
    
    public void put(int key, int value) {
        if ( !map.containsKey(key) && count >= capacity ) rmOldest();
        else if ( !map.containsKey(key) ) count++;
        else pullNode(key);
        addLatest(key,value);
    }

    private void pullNode(int key) {
        Node cur = map.get(key);
        cur.prev.next = cur.next;
        cur.next.prev = cur.prev;
    }

    private void rmOldest() {
        Node node = oldest.next;
        map.remove(node.key);
        oldest.next.next.prev = oldest;
        oldest.next = oldest.next.next;
    }

    private void addLatest(int key, int value) {
        Node cur = new Node(key,value);
        cur.prev = latest.prev;
        cur.next = latest;
        latest.prev.next = cur;
        latest.prev = cur;
        map.put(key,cur);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */