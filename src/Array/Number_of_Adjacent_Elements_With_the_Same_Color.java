package Array;

/** 2672. Number of Adjacent Elements With the Same Color

     思路就是每次改变之前看一下这个 arr[i] 左右两边相邻位有多少个same color，
     用 pre 记录，然后再 看一下改颜色后还有多少个，用after 记录
     然后  总数 += (after - pre)


     0 0 0 1 1 2 2 2 0 0
            +i_
     pre = 1               [i,3]  1-->3 change 1 to 3
     after = 0
     overal count--;

     pre = 1               [i,2]  1-->2 change 1 to 2
     after = 1
     overal count keep;

 */
public enum Number_of_Adjacent_Elements_With_the_Same_Color {
    public int[] colorTheArray(int n, int[][] queries) {
        int[] arr = new int[n];
        int count = 0;
        int[] res = new int[queries.length];
        for(int i = 0; i<queries.length; i++){
            int[] q = queries[i];
            int idx = q[0];
            int color = q[1];

            int pre = 0;
            if(idx>0 && arr[idx-1]!=0 &&  arr[idx-1] == arr[idx]) pre++;
            if(idx<n-1 && arr[idx+1]!=0 && arr[idx+1] == arr[idx]) pre++;

            int after = 0;
            if(idx>0 && arr[idx-1]!=0 && arr[idx-1] == color) after++;
            if(idx<n-1 &&arr[idx+1]!=0 && arr[idx+1] == color) after++;
            count += (after-pre);
            arr[idx] = color;
            res[i] = count;
        }
        return res;
    }
}
