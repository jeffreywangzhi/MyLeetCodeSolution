class Solution {
    private HashMap<String,HashSet<Integer>> map = new HashMap<>();
    private HashSet<Integer> visited = new HashSet<>();
    private List<List<String>> res = new ArrayList<>();
    private List<List<String>> accounts = new ArrayList<>();
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        this.accounts = accounts;
        for ( int i = 0; i < accounts.size(); i++ ) {
            List<String> account = accounts.get(i);
            for ( int j = 1; j < account.size(); j++ ) {
                String temail = account.get(j);
                if ( !map.containsKey(account.get(j)) ) {
                    List<Integer> cur = Arrays.asList(i);
                    map.put(temail, new HashSet<>(cur));
                } else {
                    HashSet<Integer> list = map.computeIfAbsent(temail, k -> new HashSet<>());
                    if ( !list.contains(i) ) list.add(i);
                }
            }
        }
        for ( int i = 0; i < accounts.size(); i++ ) {
            if ( visited.contains(i) ) continue;
            List<String> account = accounts.get(i);
            String name = account.get(0);
            HashSet<String> set = new HashSet<>();
            helper(account,name,set,i);
            List<String> temp = new ArrayList<>(set);
            Collections.sort(temp);
            temp.add(0,name);
            res.add(temp);
        }
        return res;
    }
    private void helper(List<String> account, String name, HashSet<String> set, int p) {
        visited.add(p);
        for ( int j = 1; j < account.size(); j++ ) {
            String temail = account.get(j);
            set.add(temail);
            for ( Integer num : map.get(temail) ) {
                if ( visited.contains(num) ) continue;
                else {
                    helper(accounts.get(num),name,set,num);
                }
            }
        }
    }
}