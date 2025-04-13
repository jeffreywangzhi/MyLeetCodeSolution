import java.util.*;

public class interview {
    public static void main(String[] args) {
        List<List<String>> input1 = new ArrayList<>();
        input1.add(Arrays.asList("1", "Books"));
        input1.add(Arrays.asList("2", "Books"));
        input1.add(Arrays.asList("1", "Books"));
        input1.add(Arrays.asList("2", "Furniture"));
        System.out.println(findCategoryWithMostSingleCategoryCustomers(input1)); // Output: Books
        
        List<List<String>> input2 = new ArrayList<>();
        input2.add(Arrays.asList("1", "Books"));
        input2.add(Arrays.asList("2", "Books"));
        input2.add(Arrays.asList("1", "Books"));
        input2.add(Arrays.asList("2", "Furniture"));
        input2.add(Arrays.asList("3", "Furniture"));
        input2.add(Arrays.asList("4", "Furniture"));
        System.out.println(findCategoryWithMostSingleCategoryCustomers(input2)); // Output: Furniture
    }
    // IP: [[1, Books], [2, Books], [1, Books], [2, Furniture]]
    // Output: Books
    // IP: [[1, Books], [2, Books], [1, Books], [2, Furniture], [3, Furniture], [4, Furniture]]
    // Output: Furniture
    public static String findCategoryWithMostSingleCategoryCustomers(List<List<String>> input) {
        HashMap<String,HashSet<String>> map = new HashMap<>();
        for ( List<String> list : input ) {
            if ( !map.containsKey(list.get(0)) ) map.put(list.get(0),new HashSet<>());
            map.get(list.get(0)).add(list.get(1));
        }
        HashMap<String,Integer> cnt = new HashMap<>();
        for ( HashSet<String> set : map.values() ) {
            if ( set.size() != 1 ) continue;
            List<String> tmp = new ArrayList<>(set);
            cnt.put(tmp.get(0),cnt.getOrDefault(tmp.get(0),0)+1);
        }
        String resCategory = "";
        int resCnt = 0;
        for ( Map.Entry<String,Integer> entry : cnt.entrySet() ) {
            if ( resCnt < entry.getValue() ) {
                resCategory = entry.getKey();
                resCnt = entry.getValue();
            }
        }
        return resCategory;
    }
}