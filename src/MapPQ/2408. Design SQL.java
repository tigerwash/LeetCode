class SQL {
    // Map 套map，多用一个map 存每个table 的最后 index
    Map<String, Map<Integer, List<String>>> map;
    Map<String, Integer> idxmap;
    public SQL(List<String> names, List<Integer> columns) {
        map = new HashMap();
        idxmap = new HashMap();
        // int size = columns.size();
        for(String s : names) {
            Map<Integer, List<String>> table = new HashMap();
            // List<String> r = new ArrayList<>();
            map.put(s, table);
            idxmap.put(s, 1);
        }
    }

    public void insertRow(String name, List<String> row) {
        Map<Integer, List<String>> table = map.get(name);
        int idx = idxmap.get(name);
        table.put(idx,row);
        idxmap.put(name, ++idx);
        map.put(name, table); // needed?
    }

    public void deleteRow(String name, int rowId) {
        Map<Integer, List<String>> table = map.get(name);
        table.remove(rowId);
        map.put(name, table);
    }

    public String selectCell(String name, int rowId, int columnId) {
        Map<Integer, List<String>> table = map.get(name);
        List<String> row = table.get(rowId);
        System.out.print("columnId: ");
        System.out.print(columnId);
        return row.get(columnId-1);
    }
}