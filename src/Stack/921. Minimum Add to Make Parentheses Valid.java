class Solution {
    public int minAddToMakeValid(String s) {
        int left = 0;
        int openright = 0;
        for(char c : s.toCharArray()) {
            if(c=='(') {
                left++;
            } else {
                if(left>0){
                    left--;
                }else {
                    openright++;
                }
            }
        }
        return left + openright;
    }
}