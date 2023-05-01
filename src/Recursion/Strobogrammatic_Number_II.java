package Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 247. Strobogrammatic Number II

 通过递归，每次都首尾加上 想要的字母， 注意最后一步的时候不能加 "0"
 * */
public class Strobogrammatic_Number_II {

    public List<String> findStrobogrammatic(int n) {
        return helper(n, n);
    }

    // <level, final length>
    private List<String> helper(int n, int length) {
        if(n == 0) return new ArrayList<String>(Arrays.asList(""));
        if(n == 1) return new ArrayList<String>(Arrays.asList("0","1","8"));

        // get base
        List<String> list = helper(n-2, length);

        List<String> curlist = new ArrayList();
        for(int i = 0; i<list.size(); i++){
            String cur = list.get(i);
            // avoid 0 in the start
            if(n != length){
                curlist.add("0" + cur + "0");
            }
            curlist.add("1" + cur + "1");
            curlist.add("8" + cur + "8");
            curlist.add("6" + cur + "9");
            curlist.add("9" + cur + "6");
        }
        return curlist;
    }}
