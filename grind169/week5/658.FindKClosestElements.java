class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> res = new ArrayList<>();
        for ( int i : arr ) res.add(i);
        while ( res.size() > k ) {
            int s = res.size()-1, a = res.get(0), b = res.get(s);
            if ( Math.abs(a-x) <= Math.abs(b-x) ) res.remove(s);
            else res.remove(0);
        }
        return res;
    }
}