package Array;

import java.util.Arrays;
import java.util.Comparator;

/**
 2343. Query Kth Smallest Trimmed Number

 此题难点在于 手动写 string 大数 的comparator

 * **/
public class Query_Kth_Smallest_Trimmed_Number {
    public int[] smallestTrimmedNumbers(String[] nums, int[][] queries) {
        int[] res = new int[queries.length];
        int len = nums[0].length();
        for(int i = 0; i< queries.length; i++){
            int k = queries[i][0];
            int trim = queries[i][1];
            // [val, index]
            String[][] arr = new String[nums.length][];
            for(int j = 0; j< nums.length; j++){
                String s = nums[j];
                String newNum = s.substring(len-trim, len);
                arr[j] = new String[]{newNum, String.valueOf(j)};
            }
            Arrays.sort(arr, new MyComparator() );
            res[i] = Integer.valueOf(arr[k-1][1]);
        }
        return res;
    }

    public class MyComparator implements Comparator<String[]> {
        @Override
        public int compare(String[] p1, String[] p2) {
            String s1 = p1[0];
            String s2 = p2[0];
            if (s1.length() != s2.length()) {
                return s1.length() - s2.length(); // shorter string is less than longer string
            }
            // compare each digit from left to right
            for (int i = 0; i < s1.length(); i++) {
                char c1 = s1.charAt(i);
                char c2 = s2.charAt(i);
                if (c1 != c2) {
                    return c1 - c2; // return the difference in ASCII codes of the two characters
                }
            }
            return 0; // the two numbers are equal
        }
    }
}
