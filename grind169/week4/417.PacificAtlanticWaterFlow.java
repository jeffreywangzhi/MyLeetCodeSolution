class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> res = new ArrayList<>();
        int[][] record1 = new int[heights.length][heights[0].length];
        int[][] record2 = new int[heights.length][heights[0].length];
        for ( int i = 0; i < heights.length; i++ ) {
            for ( int j = 0; j < heights[0].length; j++ ) {
                if ( i != 0 && j != 0 ) continue;
                dfs(heights,record1,i,j,0);
            }
        }
        for ( int i = 0; i < heights.length; i++ ) {
            for ( int j = 0; j < heights[0].length; j++ ) {
                if ( i != heights.length-1 && j != heights[0].length-1 ) continue;
                dfs(heights,record2,i,j,0);
            }
        }
        for ( int i = 0; i < heights.length; i++ ) {
            for ( int j = 0; j < heights[0].length; j++ ) {
                if ( record1[i][j] == 1 && record2[i][j] == 1 ) res.add(new ArrayList<>(Arrays.asList(i,j)));
            }
        }
        return res;
    }
    public void dfs(int[][] heights, int[][] record, int i, int j, int pre) {
        if ( i < 0 || j < 0 || i >= heights.length || j >= heights[0].length ) return;
        if ( heights[i][j] < pre || record[i][j] == 1 ) return;
        record[i][j] = 1;
        dfs(heights,record,i+1,j,heights[i][j]);
        dfs(heights,record,i-1,j,heights[i][j]);
        dfs(heights,record,i,j+1,heights[i][j]);
        dfs(heights,record,i,j-1,heights[i][j]);
    }
}