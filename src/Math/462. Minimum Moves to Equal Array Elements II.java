class Solution {
    public int minMoves2(int[] nums) {
        //纯数学问题， 找到中位数即可，然后让所有其他数向他靠拢
        // 不用考虑单双数，因为前面后边的数他们和res 都一样的
        // Arrays.sort(nums);
        // int mid = nums[nums.length/2];
        // quick select 做法
        int mid = quickselect(nums, 0, nums.length-1);
        System.out.print(mid);
        int res = 0;
        for(int n : nums) {
            res += Math.abs(mid - n);
        }
        return res;
    }

    private int quickselect(int[] nums, int l, int r) {
        if(l == r) return nums[l];
        int start = l;
        int pivotidx = (r-l)/2 + l;
        int pivot = nums[pivotidx];
        swap(nums, pivotidx, r);
        for(int i = l; i< r; i++) {
            if(nums[i]<=pivot){
                swap(nums, l++, i);
            }
        }
        swap(nums, l, r);
        if(l < nums.length/2) {
            return quickselect(nums, l+1, r);
        }else if(l>nums.length/2){
            return quickselect(nums, start, l-1);
        }else {
            return nums[l];
        }
    }

    private void swap(int[] nums, int l, int r) {
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }
}