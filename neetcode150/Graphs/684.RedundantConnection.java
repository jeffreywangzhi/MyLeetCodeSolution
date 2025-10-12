class Solution {
    public int[] par;
    public int[] size;
    public int[] findRedundantConnection(int[][] edges) {
        par = new int[edges.length+1];
        size = new int[edges.length+1];
        for ( int i = 0; i < par.length; i++ ) par[i] = i;
        for ( int[] e : edges ) {
            if ( !union(e) ) return e;
        }
        return new int[]{};
    }
    public int find(int n) {
        if ( n == par[n] ) return n;
        par[n] = find(par[n]);
        return par[n];
    }
    public boolean union(int[] e) {
        int p1 = find(e[0]);
        int p2 = find(e[1]);
        if ( p1 == p2 ) return false;
        if ( size[p1] >= size[p2] ) {
            par[p2] = p1;
            size[p1]++;
        } else {
            par[p1] = p2;
            size[p2]++;
        }
        return true;
    }
}