class RandomizedSet {
    List<Integer> list;
    HashMap<Integer, Integer> map;
    public RandomizedSet() {
        list = new ArrayList<>();
        map = new HashMap<>();
    }
    
    public boolean insert(int val) {
        boolean res = map.containsKey(val) ? false : true;
        if ( res ) {
            map.put(val,list.size());
            list.add(val);
        }
        return res;
    }
    
    public boolean remove(int val) {
        boolean res = map.containsKey(val) ? true : false;
        if ( res ) {
            int idx = map.get(val);
            list.set(idx,list.get(list.size()-1));
            map.put(list.get(idx),idx);
            list.remove(list.size()-1);
            map.remove(val);
        }
        return res;
    }
    
    public int getRandom() {
        Random random = new Random();
        return list.get(random.nextInt(list.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */