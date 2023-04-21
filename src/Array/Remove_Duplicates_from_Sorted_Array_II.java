package Array;

/**
 80. Remove Duplicates from Sorted Array II

 // 每次初始时， s在相同字段的开头且未赋值，f在相同字段的末尾
 // 如果fast 在一个 dup 的数字上，就先把slow++ 附一个值
 // 1 1 1 2 3 3 3 ****
 // s   f

 * */
public class Remove_Duplicates_from_Sorted_Array_II {

    public int removeDuplicates(int[] nums) {
        if(nums.length <= 2) return 2;
        int slow = 0;
        int fast = 0;
        // 每次初始时， s在相同字段的开头且未赋值，f在相同字段的末尾
        // 如果fast 在一个 dup 的数字上，就先把slow++ 附一个值
        // 1 1 1 2 3 3 3 ****
        // s   f
        while(fast < nums.length){
            while(fast < nums.length-1 && nums[fast] == nums[fast+1]) fast++;
            // 如果 fast 是一个dup 字段末尾，则slow 先填上一个坑
            if(fast>0 && nums[fast] == nums[fast-1]){
                nums[slow++] = nums[fast];
            }
            // 不论f是不是duplicate，把当前slow位置都要和fast相等
            nums[slow++] = nums[fast++];
        }
        return slow;
    }
}
