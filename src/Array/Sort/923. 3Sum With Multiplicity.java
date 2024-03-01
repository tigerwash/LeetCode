class Solution {
    // map<num, count>
    // idMap<num, index> in identical num list
    // 分类讨论： 1.三个数相等，2。三个中的两个相等 3。各不相等
    public int threeSumMulti(int[] arr, int target) {
        long res = 0;
        int mod = (int)(1e9 + 7);
        List<Integer> list = new ArrayList();
        Map<Integer, Integer> map = new HashMap();
        Map<Integer, Integer> idMap = new HashMap();
        int idx = 0;
        for(int i= 0; i<arr.length; i++) {
            if(!map.containsKey(arr[i])) {
                list.add(arr[i]);
                idMap.put(arr[i], idx++);
            }
            map.put(arr[i], map.getOrDefault(arr[i],0)+1);
        }
        for(int i = 0; i<list.size(); i++) {
            int first = list.get(i);
            int newtarget = target - first;
            if(newtarget<0) continue;
            for(int j = i; j<list.size(); j++) {
                int second = list.get(j);
                int third = newtarget - second;
                if(map.containsKey(third) && idMap.containsKey(third) && idMap.get(third) >= j) {
                    if(first == second) {
                        if(second == third) {
                            res += ((long)map.get(third) * ((long)map.get(third)-1) * ((long)map.get(third) -2))/(3*2);
                        } else {
                            res += (long)(map.get(first) * (map.get(first)-1) * map.get(third)) / 2;
                        }
                    } else {
                        if(second == third) {
                            res += map.get(first) * map.get(second) * (map.get(second) -1) / 2;
                        } else {
                            res += map.get(first) * map.get(second) * map.get(third);
                        }
                    }
                    // res %= mod;
                }
            }
        }
        return (int)(res % mod);
    }
}