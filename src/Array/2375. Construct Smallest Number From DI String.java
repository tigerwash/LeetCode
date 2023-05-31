package Array;
/**
 2375. Construct Smallest Number From DI String

 III DI DDD
 123 54 9876
 找规律。
 先把每个位置都依次放上 123456789,
 然后碰到D 的时候把D的这一段reverse， 注意反转的这一段要比D的长度多1。
 * */


public class Construct_Smallest_Number_From_DI_String {
    public String smallestNumber(String pattern) {
        int[] arr = new int[]{1,2,3,4,5,6,7,8,9};
        int len = pattern.length();
        char[] pt = pattern.toCharArray();
        for(int i = 0; i<len; i++){
            if(pt[i] == 'D'){
                int j = i;
                while(j<len && pt[j] == 'D') j++;
//                System.out.println("i:" + i + ", j: " + j);
                reverse(arr, i,j);
                i = j;
                i--;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<len+1; i++) sb.append(arr[i]);
        return sb.toString();
    }
    private void reverse(int[] arr, int l, int r){
        while(l<r){
            int tmp = arr[r];
            arr[r] = arr[l];
            arr[l] = tmp;
            l++;
            r--;
        }
    }

}
