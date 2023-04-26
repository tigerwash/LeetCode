package Math;

import java.util.Arrays;

/**
 * 2344. Minimum Deletions to Make Array Divisible

  1. 找到  numsDivide 李所有数的 最大公约数 greatest common divisor (GCD)
  2. sort nums, 只要n 能被gcp 整除， 那么他就能被所有的 numsDivide 整除
     所以只要找出第一个sort 后 能被gcp 整除 的数 那就是最小值

 * **/
public class Minimum_Deletions_to_Make_Array_Divisible {
    public int minOperations(int[] nums, int[] numsDivide) {
        // 1. find the gcp of nums
        int gcd = numsDivide[0];
        for(int i = 1; i< numsDivide.length; i++){
            int cur = numsDivide[i];
            // 辗转相除法求gcp
            while(cur % gcd != 0){
                int t = cur % gcd;
                cur = gcd;
                gcd = t;
            }
        }
        // 2. 只要n 能被gcp 整除， 那么他就能被所有的 numsDivide 整除
        // 所以只要找出第一个sort 后 能被gcp 整除 的数 那就是最小值
        Arrays.sort(nums);
        for(int i = 0; i< nums.length; i++){
            if(gcd % nums[i] == 0){
                return i;
            }
        }
        return -1;
    }
}
