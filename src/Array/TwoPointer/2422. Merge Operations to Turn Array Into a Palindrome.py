class Solution:
    def minimumOperations(self, nums: List[int]) -> int:
        # two pointer
        l = 0
        r = len(nums)-1
        vL = nums[l]
        vR = nums[r]
        count = 0
        while l<r:
            if vL == vR:
                l+=1
                r-=1
                vL = nums[l]
                vR = nums[r]
            elif vL < vR :
                l+=1
                vL += nums[l]
                count+=1
            else :
                r-=1
                vR += nums[r]
                count+=1
        return count