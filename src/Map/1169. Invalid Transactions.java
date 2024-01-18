class Solution {
    class Node{
        String name;
        int time;
        int amount;
        String city;
        Node(String name, int time, int amount, String city) {
            this.name= name;
            this.time = time;
            this.amount = amount;
            this.city = city;
        }
    }
    /***. 找到同一个人不同城市 小于60min 时间间隔 的所有转账，
     建一个map， 对于每个人的转账记录按时间sort， 然后变相brut force
     对于每个记录查找他后面 60min timewindow 里面所有的记录，如果他俩在不同城市，那么就 作为
     invalide 加进set 中*/
    public List<String> invalidTransactions(String[] transactions) {
        Set<Node> set = new HashSet();
        List<Node> list = new ArrayList();
        Map<String, List<Node>> map = new HashMap();
        for(String s : transactions){
            String[] arr = s.split(",");
            Node cur = new Node(arr[0], Integer.valueOf(arr[1]), Integer.valueOf(arr[2]), arr[3]);
            if(!map.containsKey(cur.name)){
                map.put(cur.name, new ArrayList());
            }
            map.get(cur.name).add(cur);
        }

        for(String name : map.keySet()) {
            List<Node> curlist = map.get(name);
            Collections.sort(curlist, (a,b) -> a.time - b.time);
            // <city, preNode>
            for(int i = 0; i<curlist.size(); i++) {
                Node cur = curlist.get(i);
                if(cur.amount>1000) {
                    set.add(cur);
                    // continue;
                }
                for(int j = i+1; j< curlist.size(); j++) {
                    Node next = curlist.get(j);
                    if(next.time - cur.time <=60 ){
                        if(!cur.city.equals(next.city)) {
                            set.add(next);
                            set.add(cur);
                        }
                    }else {
                        break;
                    }
                }
            }
        }
        List<String> res = new ArrayList();
        for(Node n : set){
            res.add(n.name + "," + n.time + "," + n.amount + "," + n.city);
        }
        return res;
    }
}