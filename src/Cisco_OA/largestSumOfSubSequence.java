package Cisco_OA;

public class largestSumOfSubSequence {

    public static int getLargestSumOfSubSequence(int[] arr){
        if(arr.length == 0) return 0;
        int premin = arr[0];
        int presum = 0;
        int res = 0;
        for(int i = 0; i<arr.length; i++){
            presum += arr[i];
            premin = Math.min(presum, premin);
            res = Math.max(presum - premin, res);
        }

        return res;
    };
     public static void main(String[] args) {
         int[] test = new int[]{2,-8,3,-2,4,-1};
         int res =  getLargestSumOfSubSequence(test);
        System.out.println(res);
    }
}


