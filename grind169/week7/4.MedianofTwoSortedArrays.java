class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int arr[] = new int[m+n];
        int mid = (m+n)/2;
        int j = 0, k = 0;
        int n1,n2;
        for ( int i = 0; i <= mid; i++ ) {
            n1 = j < nums1.length ? nums1[j] : Integer.MAX_VALUE;
            n2 = k < nums2.length ? nums2[k] : Integer.MAX_VALUE;
            if ( n1 > n2 ) {
                arr[i] = n2;
                k++;
            } else {
                arr[i] = n1;
                j++;
            }
        }
        if ( mid == 0 ) return arr[0];
        return (m+n)%2 == 0 ? (arr[mid-1]+arr[mid])/2.0 : arr[mid];
    }
}