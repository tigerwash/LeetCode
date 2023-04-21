package Array;

/**
 * 334. Increasing Triplet Subsequence
 * 永远找到最小的两个， 如果再来一个数比第三个大，那就正解
 * */
public class Increasing_Triplet_Subsequence {

    public boolean increasingTriplet(int[] nums) {
        // 永远找到最小的两个， 如果再来一个数比第三个大，那就正解
        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;
        for(int n : nums){
            if(n <= first){
                first = n;
            }else if(n <= second){ // 只要到了这一层，就一定说明前面是有数比他小的
                second = n;
            }else{
                return true;
            }
        }
        return false;
    }
}
