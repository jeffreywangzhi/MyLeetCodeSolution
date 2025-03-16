class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int i = 0, j = k-1;
        while ( j < arr.length-1 ) {
            if ( Math.abs(arr[i]-x) < Math.abs(arr[j+1]-x) || ( Math.abs(arr[i]-x) == Math.abs(arr[j+1]-x) && arr[i] < arr[j+1]) ) break;
            else i++;j++;
        }
        List<Integer> res = new ArrayList<>();
        while ( i <= j ) res.add(arr[i++]);
        return res;
    }
}