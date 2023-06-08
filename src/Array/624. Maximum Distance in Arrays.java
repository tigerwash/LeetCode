class Solution {
    /**
     *  624. Maximum Distance in Arrays
     *
     在一堆sorted 的lists 中找到不在同一个list 中的两个数最大相差的值。
     最难的地方在于要规避，全局的最大值最小值在同一个lsit 中，
     所以其实我们每次比较  (curmax - list[0]) vs (list[len-1] - curmin) vs res
     即可，再相应地update。 curmax, curmin 的值
     **/
    public int maxDistance(List<List<Integer>> arrays) {
        int len0 = arrays.get(0).size();
        int min = arrays.get(0).get(0);
        int max = arrays.get(0).get(len0-1);
        int res = 0;
        for(int i = 1; i< arrays.size(); i++) {
            List<Integer> list = arrays.get(i);
            int a = Math.abs(max - list.get(0));
            int b = Math.abs(list.get(list.size() -1) - min);
            res = Math.max(res, Math.max(a, b));

            max = Math.max(max, list.get(list.size() -1) );
            min = Math.min(min, list.get(0));
        }
        return res;
    }
}