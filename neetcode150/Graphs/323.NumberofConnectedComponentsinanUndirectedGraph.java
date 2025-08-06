class DSU {
    int[] parent;
    int[] rank;
    public DSU(int n) {
        parent = new int[n];
        rank = new int[n];
        for ( int i = 0; i < n; i++ ) {
            parent[i] = i;
            rank[i] = 1;
        }
    }
    public int find(int node) {
        int cur = node;
        while ( cur != parent[cur] ) {
            parent[cur] = parent[parent[cur]];
            cur = parent[cur];
        }
        return cur;
    }
    public boolean union(int a, int b) {
        int pa = find(a);
        int pb = find(b);
        if ( pa == pb ) return false;
        if ( rank[pa] >= rank[pb] ) {
            int temp = pa;
            pa = pb;
            pb = temp;    
        }
        rank[pa] += rank[pb];
        parent[pb] = pa;
        return true;
    }
}
class Solution {
    public int countComponents(int n, int[][] edges) {
        DSU dsu = new DSU(n);
        for ( int[] edge : edges ) {
            if ( dsu.union(edge[0],edge[1]) ) n--;
        }
        return n;
    }
}