/** 1202. Smallest String With Swaps

 可以通过pair 建图，其实一个图里面的char 是可以自由流动的，所以只要找到属于同一个
 组里面的所有char，把他们按着原来的坑位从小到大排一遍续，就可以了
 具体实现，先构建map graph， 然后dfs 找到属于一个组的 char 和index， 把他们存在
 List<Character> characters 和 List<Integer> indexes 中
 再sort 他们，按着index 插入char，最后即可得最小string
 */

class Solution {
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        // graph for connected index
        Map<Integer, List<Integer>> map = new HashMap();
        for(List<Integer> p : pairs) {
            int a = p.get(0);
            int b = p.get(1);
            if(!map.containsKey(a)) map.put(a, new ArrayList());
            if(!map.containsKey(b)) map.put(b, new ArrayList());
            map.get(a).add(b);
            map.get(b).add(a);
        }
        char[] arr = s.toCharArray();
        Set<Integer> visited = new HashSet();
        for(int key : map.keySet()) {
            if(visited.contains(key)) continue;
            // 分别用characters 和indexes 两个list 来储存这属于一个group里面的index 和 character
            // 然后sort 他们，char按着indexes 插进原来的string 里头，就是最小的值
            List<Character> characters = new ArrayList();
            List<Integer> indexes = new ArrayList();

            dfs(map, key, characters, indexes, visited, s);
            Collections.sort(characters);
            Collections.sort(indexes);
            for(int i =0; i<characters.size(); i++) {
                int index = indexes.get(i);
                char curchar = characters.get(i);
                arr[index] = curchar;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(char c : arr) sb.append(c);
        return sb.toString();
    }

    private void dfs(Map<Integer, List<Integer>> map, int start, List<Character> characters,
                     List<Integer> indexes, Set<Integer> visited , String s) {
        if(visited.contains(start)) return;
        visited.add(start);
        indexes.add(start);
        characters.add(s.charAt(start));
        List<Integer> neighbors = map.get(start);
        for(int nb : neighbors) {
            if(visited.contains(nb)) continue;
            dfs(map, nb, characters, indexes, visited, s);
        }
    }
}