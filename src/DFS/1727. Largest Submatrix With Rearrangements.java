class Solution {
    public int largestSubmatrix(int[][] matrix) {
        // 先算出每个cell上面有多少个连续的1， 然后sort当前row，
        // 问题就变成了计算最大的柱状图面积
        for(int i = 1; i<matrix.length; i++) {
            for(int j = 0; j<matrix[0].length; j++) {
                if(matrix[i][j] == 1) {
                    matrix[i][j] = matrix[i-1][j] + 1;
                }
            }
        }
        // sort each row, and calculate
        int max = 0;
        for(int i = 0; i<matrix.length; i++) {
            Arrays.sort(matrix[i]);
            // 从右往左扫
            for(int j = matrix[0].length-1; j>=0; j--) {
                if(matrix[i][j]== 0) break;
                int width = matrix[0].length - j;
                max = Math.max(width * matrix[i][j], max);
            }
        }
        return max;
    }
}