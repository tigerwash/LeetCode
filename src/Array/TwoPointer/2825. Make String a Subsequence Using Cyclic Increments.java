class Solution {
    public boolean canMakeSubsequence(String str1, String str2) {
        // two pointer. 
        int j = 0;
        for(int i = 0; i< str1.length() && j<str2.length(); i++) {
            char c = str1.charAt(i);
            char c2 = str2.charAt(j);
            if(c==c2 || (c+1)==c2 || (c=='z' && (c-25)==c2)){
                j++;
            }
        }
        return j == str2.length();
    }
}