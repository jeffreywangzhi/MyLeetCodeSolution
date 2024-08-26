class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String,Integer> map = new HashMap<>();
        for ( int i = 0; i < words.length; i++ ) {
            map.put(words[i],map.getOrDefault(words[i],0)+1);
        }
        List<List<String>> list = new ArrayList<>();
        for ( Map.Entry<String,Integer> entry : map.entrySet() ) {
            list.add(new ArrayList<>(Arrays.asList(entry.getKey(),String.valueOf(entry.getValue()))));
        }
        Collections.sort(list,new Comparator<List<String>>(){
            @Override
            public int compare(List<String> a, List<String> b) {
                if ( !a.get(1).equals(b.get(1)) ) return Integer.compare(Integer.parseInt(a.get(1)),Integer.parseInt(b.get(1)));
                else return b.get(0).compareTo(a.get(0));
            }
        });
        List<String> res = new ArrayList<>();
        for ( int i = 0, j = list.size()-1; i < k; i++,j-- ) {
            res.add(list.get(j).get(0));
        }
        return res;
    }
}