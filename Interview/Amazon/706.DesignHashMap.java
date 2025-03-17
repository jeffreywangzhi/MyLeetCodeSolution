class MyHashMap {
    private final int size = 1000;
    private LinkedList<Pair>[] buckets;
    private class Pair {
        int key;
        int val;
        private Pair(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
    private int hash(int key) {
        return key%size;
    }
    public MyHashMap() {
        buckets = new LinkedList[size];
    }
    
    public void put(int key, int value) {
        int h = hash(key);
        if ( buckets[h] == null ) buckets[h] = new LinkedList<>();
        for ( Pair p : buckets[h] ) {
            if ( p.key == key ) {p.val = value;return;}
        }
        buckets[h].add(new Pair(key,value));
    }
    
    public int get(int key) {
        int h = hash(key);
        if ( buckets[h] == null ) return -1;
        for ( Pair p : buckets[h] ) {
            if ( p.key == key ) return p.val;
        }
        return -1;
    }
    
    public void remove(int key) {
        int h = hash(key);
        if ( buckets[h] == null ) return;
        Iterator<Pair> iter = buckets[h].iterator();
        while ( iter.hasNext() ) {
            if ( iter.next().key == key ) {
                iter.remove();
                return;
            }
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */