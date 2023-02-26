package Intervals;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 436. Find Right Interval
 *
 Arrays.sort(sorted, new Comparator<Integer>() {
 public int compare(Integer o1, Integer o2) {
 // Intentional: Reverse order for this demo
 return o2.compareTo(o1);
 }
 });
 interval 的头大于另一个interval 的尾，且它是最小的一个大的数，着她是right interval
 ei  ....
 sj         ej

 先按start sort 一下，然后binary search 找到最小的大值

 */
class Find_Right_Interval {
    public int[] findRightInterval(int[][] intervals) {

        int[][] arr = new int[intervals.length][];
        for(int i=0; i < intervals.length; i++){
            arr[i] = new int[]{intervals[i][0], intervals[i][1], i};
        }
        Arrays.sort(arr, new Comparator<int[]>(){
            public int compare(int[] a, int[] b){
                return a[0] - b[0];
            }
        });
        int[] res = new int[arr.length];
        for(int i =0; i<arr.length; i++){
            int[] cur = arr[i];
            int end = cur[1];
            int realindex = cur[2];
            int rightindex = binarysearch(arr, i, end);
            if(rightindex == -1){
                res[realindex] = -1;
            }else{
                res[realindex] = arr[rightindex][2];
            }
        }
        return res;
    }
    // find first index that arr[i][0] >= target
    private int binarysearch(int[][] arr, int left, int target){

        int right = arr.length-1;
        if(left > right) return -1;
        while(left < right){
            int mid = (right - left)/2+left;
            if(arr[mid][0] >= target){
                right = mid;
            }else {
                left = mid+1;
            }
        }
        if(arr[left][0] < target) return -1;
        return left;
    }
}
