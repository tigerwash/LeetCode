class Solution {
    // 记录第一个最小值和最后一个最大值的 index， 然后通过判断他俩相对位置
    // 来对最后的结果 +-1
    // 1. 如果 。小。。大。， 就是两个端点的长度直接相加
    // 2. 如果 。大。。小。， 则两端长度相加 后-1
    public int minimumSwaps(int[] nums) {
        int max = nums[0];
        int min = nums[0];
        int maxIndex = 0;
        for(int i = 0; i<nums.length; i++){
            if(nums[i]>= max){
                maxIndex = i;
                max = nums[i];
            }
            if(nums[i]<=min){
                min = nums[i];
            }
        }
        for(int i = 0; i<nums.length; i++){
            if(nums[i]==min){
                if(i<=maxIndex){
                    return nums.length-maxIndex -1 + i ;
                }else{
                    return nums.length - maxIndex - 1 + i -1;
                }
            }
        }
        return 0;
    }
}