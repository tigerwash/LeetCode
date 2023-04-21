package Array;

import java.util.Arrays;

/**
 * 2592. Maximize Greatness of an Array
 *
 * */
public class Maximize_Greatness_of_an_Array {

    public int maximizeGreatness(int[] nums) {
        // Set<Integer> set = new HashSet();
        // for(int n : nums) set.add(n);
        // return nums.length - set.size();
        int res = 0;
        Arrays.sort(nums);
        for(int n : nums){
            if(n > nums[res]){
                res++;
            }
        }
        return res;
    }

}
