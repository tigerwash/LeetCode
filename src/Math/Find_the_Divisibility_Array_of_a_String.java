package Math;
/**
 2575. Find the Divisibility Array of a String

 string大数整除， 只要一直留住 carry 就好

 * **/
public class Find_the_Divisibility_Array_of_a_String {
    public int[] divisibilityArray(String word, int m) {
        char[] arr = word.toCharArray();
        int[] res = new int[word.length()];
        long carry = 0;

        for(int i = 0; i<arr.length; i++){
            long x = carry * 10 + arr[i] - '0';
            carry = x % m;

            if(carry == 0){
                res[i] = 1;
            }
            // System.out.println(carry);
        }
        return res;

    }
}
