import java.util.*;

/**
 *  611. Valid Triangle Number
 * */

/**  Two pointer solution
 * 先定住尾巴 i ， 然后再i 之前设两个pointer  s, e 相向而行。
 * 每次只要满足 nums[s] + nums[e] > nums[i] 其实就是一个valied 的组合
 *
 *   s->....  <-e ... <- i
 * **/
class TwoPointerSolution{
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        /**
         s->....  <-e ... <- i
         */
        int res = 0;
        for(int i = nums.length-1; i>=2; i--) {
            int s = 0;
            int e = i-1;
            while(s < e) {
                if(nums[s] + nums[e] > nums[i]) {
                    res += e -s;
                    e--;
                }else if(nums[s] + nums[e] <= nums[i]){
                    s++;
                }
            }
        }
        return res;
    }

}

/***  Binary Solution
 * */
class BinarySolution {

    /**
     先定住 左边a 和右边b， binaryseach i,j找中间合条件的区间[i,j]
     a... i-> .. <-j ... b
     这个方法会超时 ： 224 / 241 test cases passed.
     **/
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        // a+b>c, b+c>a, a+c>b
        // a. b --> c <= [|a-b|, a+b]
        int res = 0;
        for(int i = 0; i< nums.length; i++){
            if(nums[i]==0) continue;
            for(int j = 0; j<i; j++) {
                if(nums[j]==0) continue;
                int a = nums[j];
                int b = nums[i];
                int left = b-a;
                int right = a+b;
                // smalles index larger than left
                int leftindex = binaryleft(nums, left);
                // largers index smaller than right
                int rightindex = binaryright(nums, right);

                leftindex = Math.max(j+1, leftindex);
                rightindex = Math.min(i-1, rightindex);
                if(leftindex > rightindex) continue;
                System.out.println(j+ ", "+ leftindex +", "+ rightindex+ ", "+ i);
                res = res + (rightindex - leftindex + 1 );
            }
        }
        return res;
    }

    // smalles index larger than left
    private int binaryleft(int[] arr, int target) {
        int l = 0;
        int r = arr.length-1;
        while(l<r) {
            int mid = (r - l)/2 + l;
            if(arr[mid] <= target){
                l = mid+1;
            }else {
                r = mid;
            }
        }
        return l;
    }

    // largers index smaller than right
    private int binaryright(int[] arr, int target) {
        int l = 0;
        int r = arr.length -1;
        while(l<r) {
            int mid = (r-l+1)/2+l;
            if(arr[mid] >= target){
                r = mid -1;
            }else{
                l = mid;
            }
        }
        return r;
    }
}