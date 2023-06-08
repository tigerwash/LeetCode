
/** 531. Lonely Pixel I
 **/
class Solution {
    public int findLonelyPixel(char[][] picture) {
        int m = picture.length;
        int n = picture[0].length;
        int res = 0;
        // row[i] = k if row i has only B at index k, otherwise -1
        int[] row = new int[m];
        Arrays.fill(row, -1);
        int[] col = new int[n];
        Arrays.fill(col, -1);
        // fill row[]
        for(int i = 0; i<m ; i++) {
            int count = 0;
            int index = -1;
            for(int j = 0; j<n; j++) {
                if(picture[i][j] == 'B'){
                    count++;
                    index = j;
                }
            }
            if(count==1) row[i] = index;
        }
        // fill col[]
        for(int i = 0; i<n ; i++) {
            int count = 0;
            int index = -1;
            for(int j = 0; j<m; j++) {
                if(picture[j][i] == 'B'){
                    count++;
                    index = j;
                }
            }
            if(count==1)col[i] = index;
        }
        // check if row[] and col[] matched
        for(int i = 0; i< m; i++) {
            if(row[i] >= 0 && col[row[i]] == i) res++;
        }

        return res;
    }
}