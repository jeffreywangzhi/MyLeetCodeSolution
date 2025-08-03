class Solution {
    private static final int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int[][] pac = new int[heights.length][heights[0].length];
        int[][] atl = new int[heights.length][heights[0].length];
        for ( int i = 0; i < heights.length; i++ ) {
            for ( int j = 0; j < heights[0].length; j++ ) {
                if ( i == 0 || j == 0 ) {
                    dfs(heights,pac,i,j,0);
                } else continue;
            }
        }
        for ( int i = 0; i < heights.length; i++ ) {
            for ( int j = 0; j < heights[0].length; j++ ) {
                if ( i == heights.length-1 || j == heights[0].length-1 ) {
                    dfs(heights,atl,i,j,0);
                } else continue;
            }
        }
        List<List<Integer>> res = new ArrayList<>();
        for ( int i = 0; i < pac.length; i++ ) {
            for ( int j = 0; j < pac[0].length; j++ ) {
                if ( pac[i][j] == 1 && atl[i][j] == 1 ) res.add(new ArrayList<>(Arrays.asList(i,j)));
            }
        }
        return res;
    }
    private void dfs(int[][] heights, int[][] grid, int i, int j, int pre) {
        if ( i < 0 || i >= heights.length || j < 0 || j >= heights[0].length ) return;
        if ( grid[i][j] == 1 || heights[i][j] < pre ) return;
        grid[i][j] = 1;
        for ( int[] dir : dirs ) dfs(heights,grid,i+dir[0],j+dir[1],heights[i][j]);
    }
}