package Binary_Search;
/**
 1539. Kth Missing Positive Number
 二分法可算，
 构建新数列 arr[mid] - mid -1, 找到第一个 mid 使得其不大于 k
 * **/

public class Kth_Missing_Positive_Number {
    // 二分法写法
    public int findKthPositive(int[] arr, int k) {
        int l = 0 ; int r = arr.length-1;
        while(l<r){
            int mid = (r-l)/2+l;
            if(arr[mid] - mid -1 < k){
                l = mid+1;
            }else {
                r = mid;
            }
        }
        // return arr[l] -l -1 < k?  arr[l] + (k - (arr[l] - l -1)) : arr[l] - ((arr[l] - l )-k) ;
        return arr[l] -l -1 < k?  k + l + 1 : l + k ;
    }

    // O(n) 写法，扫一遍
    public int findKthPositive_binary(int[] arr, int k) {
        int i = 0;
        for(int n = 0; n<2002; n++){
            if(i<arr.length && arr[i] == n){ // not miss
                i++;
            }else{ // miss
                k--;
            }
            if(k<0) return n;
        }
        return -1;
    }

}
