class TimeMap {
    Map<String, TreeMap<Integer, String>> dataMap;
    public TimeMap() {
        dataMap = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        dataMap.computeIfAbsent(key, k -> new TreeMap<>()).put(timestamp, value);
        // if ( !dataMap.containsKey(key) ) {
        //     TreeMap<Integer,String> innermap = new TreeMap<>();
        //     innermap.put(timestamp,value);
        //     dataMap.put(key,innermap);
        // } else dataMap.get(key).put(timestamp,value);
    }
    
    public String get(String key, int timestamp) {
        if (!dataMap.containsKey(key)) return "";
        Map.Entry<Integer, String> entry = dataMap.get(key).floorEntry(timestamp);
        return entry == null ? "" : entry.getValue();
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */