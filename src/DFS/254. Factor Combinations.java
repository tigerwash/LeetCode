/**
 * 254. Factor Combinations
 * **/

class Solution {
    /**
     dfs, 每一层都便利到 n 的因数， 然后对 因数继续 dfs
     维护一个path 记录每一次碰到的 因数
     **/
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> res = new ArrayList();
        List<Integer> path = new ArrayList();
        dfs(res, path, n, 2);
        return res;
    }

    private void dfs(List<List<Integer>> res, List<Integer> path, int base, int start) {
        if(base<=1) {
            if(path.size() > 1) // filter itself [n]
                res.add(new ArrayList(path));
            return;
        }// 注意这里要是start 开始
        // start 开头可以避免出现[3, 4], [4,3] 的情况，保证path 里的值一定递增
        for(int i = start; i<=base; i++) {
            if(base%i == 0) {
                path.add(i);
                dfs(res, path, base/i, i);
                path.remove(path.size()-1);
            }
        }
    }
}