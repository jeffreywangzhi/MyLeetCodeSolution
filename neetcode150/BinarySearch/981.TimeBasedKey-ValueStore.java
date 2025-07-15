class TimeMap {
    private class Pair {
        int time;
        String val;
        private Pair (int time, String val) {
            this.time = time;
            this.val = val;
        }
    }
    private HashMap<String,ArrayList> map;
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        map.putIfAbsent(key, new ArrayList<>());
        map.get(key).add(new Pair(timestamp, value));
    }
    
    public String get(String key, int timestamp) {
        if ( !map.containsKey(key) ) return "";
        ArrayList<Pair> cur = map.get(key);
        if ( cur.get(0).time > timestamp ) return "";
        int start = 0, end = cur.size()-1;
        while ( start <= end ) {
            int mid = start+(end-start)/2;
            if ( cur.get(mid).time == timestamp ) return cur.get(mid).val;
            if ( cur.get(mid).time < timestamp ) start = mid+1;
            else end = mid-1;
        }
        return cur.get(end).val;
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */