class DetectSquares {
    private HashMap<String,Integer> map;
    private List<String> pts;
    public DetectSquares() {
        map = new HashMap<>();
        pts = new ArrayList<>();
    }
    
    public void add(int[] point) {
        StringBuilder sb = new StringBuilder(""+point[0]).append(",").append(point[1]);
        String key = sb.toString();
        if ( !map.containsKey(key) ) pts.add(key);
        map.put(key,map.getOrDefault(key,0)+1);
    }
    
    public int count(int[] point) {
        int res = 0;
        for ( String p : pts ) {
            String[] pt = p.split(",");
            int x = Integer.valueOf(pt[0]);
            int y = Integer.valueOf(pt[1]);
            int dx = Math.abs(point[0]-x), dy = Math.abs(point[1]-y);
            if ( dx != 0 && dy != 0 && dx == dy ) {
                String k1 = x+","+point[1], k2 = point[0]+","+y, k3 = x+","+y;
                if ( map.containsKey(k1) && map.containsKey(k2) ) res += map.get(k1)*map.get(k2)*map.get(k3);
            } else continue;
        }
        return res;
    }
}

/**
 * Your DetectSquares object will be instantiated and called as such:
 * DetectSquares obj = new DetectSquares();
 * obj.add(point);
 * int param_2 = obj.count(point);
 */