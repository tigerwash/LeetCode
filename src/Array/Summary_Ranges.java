package Array;

import java.util.ArrayList;
import java.util.List;

/**
 228. Summary Ranges

 *
 * **/

public class Summary_Ranges {
    /**A range covers consecutive elements.
     If two adjacent elements have difference larger than 1,
     the two elements does not belong to the same range. **/

    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList();
        if(nums.length == 0) return res;
        for(int i = 0; i< nums.length; i++){
            int start = nums[i];

            while(i+1< nums.length && nums[i]+1 == nums[i+1]){
                i++;
            }
            if(nums[i] == start) {
                res.add(start + "");
            }else{
                res.add(start + "->" + nums[i]);
            }
        }
        return res;
    }
}
