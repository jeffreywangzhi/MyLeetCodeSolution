import java.util.ArrayList;
import java.util.List;

public class QuickSort {
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
        testcases.add(new int[]{3, 8, 2, 5, 1, 4, 7, 6});
        for ( int[] cases : testcases ) {
            System.out.println();
            quickSort(cases, 0, cases.length-1);
            for ( int i : cases ) System.out.print(i+" ");
        }
    }
    private static void quickSort(int[] arr, int l, int r) {
        if ( l < r ) {
            int pi = partition(arr,l,r);
            quickSort(arr, l, pi-1);
            quickSort(arr, pi+1, r);
        }
    }
    private static int partition(int[] arr, int l, int r) {
        int pivot = arr[r];
        int idx = l-1;
        for ( int i = l; i <= r-1; i++ ) {
            if ( arr[i] < pivot ) {
                idx++;
                swap(arr,idx,i);
            }
        }
        swap(arr,idx+1,r);
        return idx+1;
    }
    private static void swap(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }
}