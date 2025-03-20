import java.util.ArrayList;
import java.util.List;
import java.util.*;

public class HeapSort {
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
            for ( int num : heapSort(cases) ) System.out.print(num+" ");
        }
    }
    private static int[] heapSort(int[] arr) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for ( int num : arr ) pq.offer(num);
        for ( int i = 0; i < arr.length; i++ ) arr[i] = pq.poll();
        return arr;
    }
}