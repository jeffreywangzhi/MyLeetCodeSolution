class LRUCache {
    HashMap<Integer,Integer> map;
    List<Integer> list;
    int size;
    public LRUCache(int capacity) {
        map = new HashMap<Integer,Integer>();
        list = new ArrayList<>();
        size = capacity;
    }
    
    public int get(int key) {
        if ( !map.containsKey(key) ) return -1;
        else {
            list.remove(Integer.valueOf(key));
            list.add(key);
            return map.get(key);
        }
    }
    
    public void put(int key, int value) {
        if ( map.containsKey(key) ) {
            map.replace(key,value);
            list.remove(Integer.valueOf(key));
            list.add(key);
        } else {
            if ( list.size() == size ) {
                map.remove(list.get(0));
                list.remove(0);
            }
            map.put(key,value);
            list.add(key);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */