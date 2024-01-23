class FileSystem {
    class Node {
        Node parent;
        String name;
        Map<String, Node> children;
        int val;
        Node(Node p, String name, int val) {
            this.parent = p;
            this.name = name;
            this.val = val;
            children = new HashMap();
        }
    }
    Node root;
    public FileSystem() {
        root = new Node(null, "root", -1);
    }

    public boolean createPath(String path, int value) {
        String[] arr = path.split("/");
        Node cur = root;
        boolean nodecreated = false;
        for(int i = 1; i< arr.length; i++) {
            String curname = arr[i];
            if(!cur.children.containsKey(curname)) {
                if(i == arr.length-1) {
                    cur.children.put(curname, new Node(null, curname, value));
                    nodecreated = true;
                } else {
                    return false;
                }
            }
            cur = cur.children.get(curname);
        }
        return nodecreated;
    }

    public int get(String path) {
        String[] arr = path.split("/");
        Node cur = root;
        for(int i = 1; i< arr.length; i++) {
            String curname = arr[i];
            if(!cur.children.containsKey(curname)) {
                return -1;
            }
            cur = cur.children.get(curname);
        }
        return cur.val;
    }
}

/**
 * Your FileSystem object will be instantiated and called as such:
 * FileSystem obj = new FileSystem();
 * boolean param_1 = obj.createPath(path,value);
 * int param_2 = obj.get(path);
 */