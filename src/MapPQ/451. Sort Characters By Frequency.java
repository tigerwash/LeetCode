class Solution {
    class Node {
        char c;
        int count;
        Node(char c , int count){
            this.c = c;
            this.count = count;
        }
    }
    public String frequencySort(String s) {
        PriorityQueue<Node> pq = new PriorityQueue<>((a,b) -> b.count-a.count);
        Map<Character, Integer> map = new HashMap();
        for(char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0)+1);
        }
        for(char c : map.keySet()) {
            if(map.get(c)>0) {
                pq.add(new Node(c, map.get(c)));
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()) {
            Node cur = pq.poll();
            int count = cur.count;
            while(count>0) {
                sb.append(cur.c);
                count--;
            }
        }
        return sb.toString();
    }
}