package Array;

/**
 186. Reverse Words in a String II
 题目要求inplace 地把 char[] reverse 一下，这个reverse 只调换单词的位置
 但是单词自己的位置是不换的

 分两步解决：
 1。 将arr 全都reverse 一下，包括单词
 2。 对于每个单词再reverse操作，这样将其恢复原位

 hello world
 dlrow olleh
 world hello
 * */
public class Reverse_Words_in_a_String_II {
    public void reverseWords(char[] s) {
        for(int i = 0; i< s.length/2; i++){
            swap(s, i, s.length-1-i);
        }

        int pre = -1;
        for(int i = 0; i<s.length; i++){
            if(s[i] == ' '){
                reversePortion(s, pre, i);
                pre = i;
            }
        }
        reversePortion(s, pre, s.length);
    }

    private void swap(char[] arr, int l , int r) {
        char t = arr[r];
        arr[r] = arr[l];
        arr[l] = t;
    }

    private void reversePortion(char[] arr, int l, int r){
        for(int i = l+1; i<=(r-l)/2+ l; i++){
            swap(arr, i, r-1-(i-l-1));
        }
    }
}
