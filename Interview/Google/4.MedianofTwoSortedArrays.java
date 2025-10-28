class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int l1 = nums1.length, l2 = nums2.length;
        if ( l1 > l2 ) return findMedianSortedArrays(nums2,nums1);
        int k = (l1+l2+1)/2;
        int l = 0, r = l1;
        int m1 = 0, m2 = 0;
        while ( l < r ) {
            m1 = l+(r-l)/2;
            m2 = k-m1;
            if ( nums1[m1] < nums2[m2-1] ) l = m1+1;
            else r = m1;
        }
        m1 = l; m2 = k-m1;
        int n1 = Math.max( m1 <= 0 ? Integer.MIN_VALUE : nums1[m1-1], m2 <= 0 ? Integer.MIN_VALUE : nums2[m2-1] );
        if ( (l1+l2)%2 == 1 ) return n1;
        int n2 = Math.min( m1 >= l1 ? Integer.MAX_VALUE : nums1[m1], m2 >= l2 ? Integer.MAX_VALUE : nums2[m2] );
        return (n1+n2)/2.0;
    }
}