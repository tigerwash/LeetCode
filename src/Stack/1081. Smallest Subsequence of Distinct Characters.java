import java.util.*;

/**
 * 1081. Smallest Subsequence of Distinct Characters
 * */

class Solution {
    /**
     先记录下每个char 最后出现的位置，
     然后建一个stack 再走一遍，如果新来的char 比之前的小，
     而且之前的char 后面还会出现，那就把那个pop出去把现在这个小的 push 进 stack
     注意需要再有一个 set 来记忆时候这个char 已经被放进去了
     */
    public String smallestSubsequence(String s) {
        int[] last = new int[26];
        for(int i = 0; i< s.length(); i++) {
            last[s.charAt(i) - 'a'] = i;
        }
        Set<Character> set = new HashSet();
        Stack<Character> stack = new Stack();
        for(int i = 0; i< s.length(); i++) {
            char c = s.charAt(i);

            if(set.contains(c)) continue;
            while(!stack.isEmpty() && stack.peek() > c && last[stack.peek() -'a'] > i){
                set.remove(stack.peek());
                stack.pop();
            }
            stack.push(c);
            set.add(c);

        }
        StringBuilder sb = new StringBuilder();
        for(char c : stack) sb.append(c);
        return sb.toString();
    }
}