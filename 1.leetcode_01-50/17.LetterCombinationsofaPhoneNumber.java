public class Solution {
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return new ArrayList<>();
        }
        String phoneMap[] = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

        List<String> combinations = new ArrayList<>();
        combinations.add("");

        for ( char digit : digits.toCharArray() ) {
            List<String> new_combinations = new ArrayList<>();
            for ( String combination : combinations ) {
                for ( char letter : phoneMap[digit-'2'].toCharArray() ) {
                    StringBuilder res = new StringBuilder();
                    res.append(combination);
                    res.append(letter);
                    new_combinations.add(res.toString());
                }
            }
            combinations = new_combinations;
        }

        return combinations;
    }
}
