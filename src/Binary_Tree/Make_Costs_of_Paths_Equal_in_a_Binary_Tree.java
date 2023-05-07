package Binary_Tree;
/***
 2673. Make Costs of Paths Equal in a Binary Tree

    这个题最大的难度在于提炼题意， 其实理解后提炼思想就是
    make left and right branch equal
    最简单的dfs 就可以算出来让左右两支相等的所需 +1 次数
 * */
public class Make_Costs_of_Paths_Equal_in_a_Binary_Tree {
    int res = 0;
    public int minIncrements(int n, int[] cost) {
        findmax(n, cost, 1);
        return res;
    }


    public int findmax(int n, int[] cost, int cur){
        if(cur > n) return 0;
        int left = findmax(n, cost, cur*2);
        int right = findmax(n, cost, cur*2+1);
        res += Math.abs(left - right);
        return Math.max(left, right) + cost[cur-1];
    }
}

