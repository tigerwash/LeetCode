class Solution {
    public int numSteps(String s) {
        StringBuilder sb = new StringBuilder(s);
        int count = 0;
        int len = sb.length();
        while(sb.length()>1) {
            if(sb.charAt(sb.length()-1) == '0') {
                sb.deleteCharAt(sb.length()-1);
                count++;
            }else {
                int j = sb.length() -1;
                while(j >= 0 && sb.charAt(j) == '1') {
                    sb.setCharAt(j--, '0');
                }
                if(j>0) {
                    sb.setCharAt(j, '1');
                }else {
                    sb.insert(0, '1');
                }
                count++;
            }
        }
        return count;
    }
}