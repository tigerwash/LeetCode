class Solution {
    public int minOperations(String s) {
        // 分两种可能 010101 or 101010
        int a = 0;
        int b = 0;
        int atag = '0';
        int btag = '1';
        for(char c : s.toCharArray()){
            if(c != atag) a++;
            if(c != btag) b++;
            atag = atag=='0' ? '1' : '0';
            btag = btag=='0' ? '1' : '0';
        }
        return Math.min(a, b);
    }
}