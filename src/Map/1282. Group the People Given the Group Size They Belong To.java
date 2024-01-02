class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        // map <group size, List<int> > 当list坑位满了之后直接挪出放进 res 里，这样可以下一步计算
        Map<Integer, List<Integer>> map = new HashMap();
        List<List<Integer>> res = new ArrayList();
        for(int i = 0; i<groupSizes.length; i++) {
            int size = groupSizes[i];
            if(!map.containsKey(size)) {
                map.put(groupSizes[i], new ArrayList());
            }
            List<Integer> group = map.get(size);
            group.add(i);
            if(group.size() == size ) {
                res.add(group);
                map.remove(size);
            }
        }
        return res;
    }
}