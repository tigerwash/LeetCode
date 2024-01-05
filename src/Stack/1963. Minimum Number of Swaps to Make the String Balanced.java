class Solution {
    public int minSwaps(String s) {
        // 从左往右扫一遍，可以算出来有多少组unmatch 的， 而且肯定是]][[ 的形式。
        // 对于他 ]][[，只要swap 一次就可以，所以是(未配对括号对数 + 1) / 2
        int left = 0; // [ 相当于oush 进stack 中
        int res = 0;
        for(char c : s.toCharArray()) {
            if(c == '[') {
                left++;
            } else {
                if(left > 0) {
                    left--;
                }else {
                    res++;
                }
            }
        }
        return (res + 1)/2;
    }
}