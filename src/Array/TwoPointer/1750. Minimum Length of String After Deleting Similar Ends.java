class Solution {
    public int minimumLength(String s) {
        int l = 0;
        int r = s.length()-1;
        while(l<r && s.charAt(l) == s.charAt(r)) {
            char c = s.charAt(l);
            while(l<s.length() && s.charAt(l) == c) l++;
            while(l<r && s.charAt(r)==c) r--;
        }
        return r-l+1;
    }
}