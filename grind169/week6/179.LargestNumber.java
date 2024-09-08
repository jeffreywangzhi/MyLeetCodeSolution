class Solution {
    public String largestNumber(int[] nums) {
        List<String> list = new ArrayList<>();
        for ( int num : nums ) list.add(String.valueOf(num));
        Collections.sort(list, new Comparator<String>(){
            @Override
            public int compare(String a, String b) {
                String str1 = a+b;
                String str2 = b+a;
                return str2.compareTo(str1);
            }
        });
        if ( list.get(0).equals("0") ) return "0";
        StringBuilder res = new StringBuilder();
        for ( String s : list ) res.append(s);
        return res.toString();
    }
}