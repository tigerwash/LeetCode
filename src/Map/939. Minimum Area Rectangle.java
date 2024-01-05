class Solution {
    public int minAreaRect(int[][] points) {
        // 找对角线的两点，然后看另外两点是否存在
        Map<Integer, Set<Integer>> map = new HashMap();
        for(int i = 0; i< points.length; i++) {
            int[] p = points[i];
            if(!map.containsKey(p[0])) map.put(p[0], new HashSet());
            map.get(p[0]).add(p[1]);
        }

        int res = Integer.MAX_VALUE;
        for(int i = 0; i< points.length-1; i++) {
            for(int j = i+1; j<points.length; j++) {
                int[] p1 = points[i];
                int[] p2 = points[j];
                if(p1[0]==p2[0] || p1[1]==p2[1]) continue; // exclude same x， y
                //find [p1[0], p2[1]] && [p2[0], p1[1]]
                if(map.get(p1[0]).contains(p2[1]) && map.get(p2[0]).contains(p1[1])) {
                    res = Math.min(res, Math.abs((p1[0]-p2[0]) * (p1[1]-p2[1])));
                }
            }
        }
        return res== Integer.MAX_VALUE? 0 : res;
    }
}