class Solution {
    private class Node {
        String num;
        double val;
        private Node(String num, double val) {
            this.num = num;
            this.val = val;
        }
    }
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        HashMap<String,List<Node>> map = new HashMap<>();
        for ( int i = 0; i < equations.size(); i++ ) {
            if ( !map.containsKey(equations.get(i).get(0)) ) map.put(equations.get(i).get(0),new ArrayList<>());
            map.get(equations.get(i).get(0)).add(new Node(equations.get(i).get(1),values[i]));
            if ( !map.containsKey(equations.get(i).get(1)) ) map.put(equations.get(i).get(1),new ArrayList<>());
            map.get(equations.get(i).get(1)).add(new Node(equations.get(i).get(0),1/values[i]));
        }
        double[] res = new double[queries.size()];
        for ( int i = 0; i < queries.size(); i++ ) {
            res[i] = dfs(map,queries.get(i).get(0),queries.get(i).get(1),0,1,new HashSet<>());
        }
        return res;
    }
    private double dfs(HashMap<String,List<Node>> map, String start, String end, int idx, double curd, HashSet<String> set) {
        if ( !map.containsKey(start) ) return -1;
        if ( start.equals(end) ) return curd;
        if ( set.contains(start) ) return -1;
        set.add(start);
        for ( Node n : map.get(start) ) {
            double r = dfs(map,n.num,end,idx+1,curd*n.val,set);
            if ( r != -1 ) return r;
        }
        return -1;
    }
}