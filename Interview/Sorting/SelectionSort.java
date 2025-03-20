import java.util.ArrayList;
import java.util.List;

public class SelectionSort {
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
            for ( int num : selectionSort(cases) ) System.out.print(num+" ");
        }
    }
    private static int[] selectionSort(int[] arr) {
        for ( int i = 0; i < arr.length; i++ ) {
            int min = i;
            for ( int j = i+1; j < arr.length; j++ ) {
                if ( arr[j] < arr[min] ) min = j;
            }
            int tmp = arr[i];
            arr[i] = arr[min];
            arr[min] = tmp;
        }
        return arr;
    }
}