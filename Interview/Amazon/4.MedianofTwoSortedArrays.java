class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int mid = (nums1.length+nums2.length)/2;
        int arr[] = new int[mid+1];
        int i = 0, j = 0, k = 0;
        while ( i <= mid ) {
            int n1 = j < nums1.length ? nums1[j] : Integer.MAX_VALUE;
            int n2 = k < nums2.length ? nums2[k] : Integer.MAX_VALUE;
            if ( n1 <= n2 ) {
                arr[i] = n1;
                j++;
            } else {
                arr[i] = n2;
                k++;
            }
            i++;
        }
        return (nums1.length+nums2.length)%2 == 0 ? (arr[mid]+arr[mid-1])/2.0 : arr[mid];
    }
}