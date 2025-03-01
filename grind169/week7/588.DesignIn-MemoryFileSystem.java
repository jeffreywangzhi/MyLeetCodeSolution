class FileSystem {
    private HashMap<String,HashMap> dic;
    private HashMap<String,String> contentMap;
    public FileSystem() {
        dic = new HashMap<>();
        contentMap = new HashMap<>();
    }
    
    public List<String> ls(String path) {
        List<String> res = new ArrayList<>();
        if ( contentMap.containsKey(path) ) {
            String[] pathArr = path.split("/");
            res.add(pathArr[pathArr.length-1]);
            return res;
        }
        String[] pathArr = path.split("/");
        HashMap<String,HashMap> tmp = dic;
        for ( int i = 1; i < pathArr.length; i++ ) {
            tmp = tmp.get("/"+pathArr[i]);
        }
        for ( Map.Entry<String,HashMap> entry : tmp.entrySet() ) {
            res.add(entry.getKey().substring(1));
        }
        Collections.sort(res);
        return res;
    }
    
    public void mkdir(String path) {
        String[] pathArr = path.split("/");
        HashMap<String,HashMap> tmp = dic;
        for ( int i = 1; i < pathArr.length; i++ ) {
            if ( !tmp.containsKey("/"+pathArr[i]) ) {
                tmp.put("/"+pathArr[i],new HashMap<>());
            }
            tmp = tmp.get("/"+pathArr[i]);
        }
    }
    
    public void addContentToFile(String filePath, String content) {
        String[] pathArr = filePath.split("/");
        HashMap<String,HashMap> tmp = dic;
        for ( int i = 1; i < pathArr.length; i++ ) {
            if ( i == pathArr.length-1 ) {
                tmp.put("!"+pathArr[i],new HashMap<>());
                contentMap.put(filePath,contentMap.getOrDefault(filePath,"")+content);
                break;
            }
            if ( !tmp.containsKey("/"+pathArr[i]) ) {
                tmp.put("/"+pathArr[i],new HashMap<>());
            }
            tmp = tmp.get("/"+pathArr[i]);
        }
    }
    
    public String readContentFromFile(String filePath) {
        return contentMap.get(filePath);
    }
}

/**
 * Your FileSystem object will be instantiated and called as such:
 * FileSystem obj = new FileSystem();
 * List<String> param_1 = obj.ls(path);
 * obj.mkdir(path);
 * obj.addContentToFile(filePath,content);
 * String param_4 = obj.readContentFromFile(filePath);
 */