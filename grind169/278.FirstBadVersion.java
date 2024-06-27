/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

      public class Solution extends VersionControl {
        public int firstBadVersion(int n) {
            return bs(1, n);
        }
        private int bs(int start, int end) {
            if ( start > end ) return start;
            int mid = start+(end-start)/2;
            return isBadVersion(mid) ? bs(start, mid-1) : bs(mid+1, end);
        }
    }