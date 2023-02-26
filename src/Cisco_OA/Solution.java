package Cisco_OA;


import java.util.*;
import java.lang.*;
import java.io.*;
// import java.util.TreeSet;
/*
 * inputStr, represents the given string for the puzzle
 */
public class Solution
{

    public static void  funcSubstring(String inputStr)
    {
        // Write your code here
        char[] arr = inputStr.toCharArray();
        int max = 1;
        String res = inputStr.substring(0,1);
        TreeSet<String> output = new TreeSet<String>();
        for(int i = 0; i<arr.length; i++){
            int l = i;
            int r = i;
            // deduplicate center
            while(i<arr.length - 1 && arr[i] == arr[i+1]){
                i++;
                r++;
            };
            while(l >= 0 && r<arr.length && arr[l] == arr[r]){
                l--;
                r++;
            }
            if(max == r-l+1){
                output.add(inputStr.substring(l+1, r));
                res = inputStr.substring(l+1, r);
            }else if(max < r-l+1){
                max = r-l+1;
                output.clear();
                output.add(inputStr.substring(l+1, r));
                res = inputStr.substring(l+1, r);
            }
        }
        // System.out.print(output.first());
        System.out.print(res);
        return ;

    }

    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);

        // input for inputStr
        String inputStr = in.nextLine();


        funcSubstring(inputStr);
    }
}