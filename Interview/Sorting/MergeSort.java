import java.util.ArrayList;
import java.util.List;

public class MergeSort {
    public static void main(String[] args) {
        List<int[]> testcases = new ArrayList<>();
        testcases.add(new int[]{23, 1, 10, 5, 2});
        testcases.add(new int[]{1, 2, 3, 4, 5});
        testcases.add(new int[]{9, 7, 5, 3, 1});
        testcases.add(new int[]{4, 4, 4, 4, 4});
        testcases.add(new int[]{7});
        testcases.add(new int[]{});
        testcases.add(new int[]{3, -1, 4, -5, 2});
        testcases.add(new int[]{100000, 50000, 1000, 500, 100});
        testcases.add(new int[]{5, 1000000, 2, 999, 10});
        for ( int[] cases : testcases ) {
            System.out.println();
            mergeSort(cases, 0, cases.length-1);
            for ( int i : cases ) System.out.print(i+" ");
        }
    }
    private static void mergeSort(int[] arr, int l, int r) {
        if ( l < r ) {
            int m = l+(r-l)/2;
            mergeSort(arr, l, m);
            mergeSort(arr, m+1, r);
            merge(arr,l,m,r);
        }
    }
    private static void merge(int[] arr, int l, int m, int r) {
        int[] cur = new int[r-l+1];
        int i = 0, p1 = l, p2 = m+1;
        while ( p1 <= m || p2 <= r ) {
            int n1 = p1 <= m ? arr[p1] : Integer.MAX_VALUE;
            int n2 = p2 <= r ? arr[p2] : Integer.MAX_VALUE;
            if ( n1 <= n2 ) {
                cur[i] = n1;
                p1++;
            } else {
                cur[i] = n2;
                p2++;
            }
            i++;
        }
        for ( int j = l; j <= r; j++ ) arr[j] = cur[j-l];
    }
}