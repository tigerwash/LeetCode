package Array;

import java.util.*;

/**
 * 1536. Minimum Swaps to Arrange a Binary Grid
 * */
class Minimum_Swaps_to_Arrange_a_Binary_Grid{
    /***
     先找到每一行尾巴上有多少个0，表示为arr[i],题目其实就是要求对每个arr[i]
     arr[i] --> n-1, n-2, n-3 ... 0
     for any i:  arr[i] >= n-1-i
     为了求最小的sort 次数，我们其实不需要把他们严格sort，只要满足arr[i] >= n-1-i 即可
     这样的话可以将每个arr[i]从大到小 assign 为一个0...n-1 的数
     **/
    public int minSwaps(int[][] grid) {
        int n = grid.length;
        int[] arr = new int[n];
        Set<Integer> visited = new HashSet();
        for(int i = 0; i<n; i++) {
            int count = 0;
            int j = n-1;
            while(j>=0 && grid[i][j] == 0){
                count++;
                j--;
            }
            // 将每一个位置都assign一个identical 的 0...n-1 的数，这样方便sort，同时也避免没有必要的sort
            for(int k = n-1; k>=0; k--){
                if(count>=k && !visited.contains(k)) {
                    arr[i] = k;
                    visited.add(k);
                    break;
                }
            }
        }
        if(visited.size() != n) return -1;
        int res = bubblesort(arr);
        return res;
    }

    // Bubble sort 成从大到小
    private int bubblesort(int[] arr) {
        int count = 0;
        for(int i = 0; i<arr.length; i++ ) {
            for(int j = 0; j<arr.length-1-i; j++) {
                if(arr[j] < arr[j+1]) {
                    int tmp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = tmp;
                    count++;
                }
            }
        }
        return count;
    }

}
