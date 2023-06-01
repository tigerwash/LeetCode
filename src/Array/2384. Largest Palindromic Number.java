package Array;

public class Largest_Palindromic_Number {
    /**
     * 2384. Largest Palindromic Number
     大致思路：
     建一个int[10] 记录每个字出现的次数，
     然后从小往大插入这些数字，即 小的数在中间，大的在两边
     最后根据sb 的长度决定怎么处理 剩下落单的数字
     1。 如果长度是单数 -->  可以把中间的数字替换成较大的
     2. 如果长度是双数。-->  把落单的数字直接插到中间
     */

    public String largestPalindromic(String num) {
        int[] map = new int[10];
        char midchar = '/';
        int maxodd = 0;
        for(char c : num.toCharArray())  map[c-'0']++;

        StringBuilder sb = new StringBuilder();
        // 两头append
        for(int i =0; i< 10; i++){
            if(map[i] == 0) continue;
            while(map[i] > 1) { // count>1 时每次首尾同时append
                sb.append((char)(i + '0'));
                sb.insert(0, (char)(i + '0'));
                map[i] -= 2;
            }
        }
        // 删掉首尾打头的0
        if(sb.length() != 0 && sb.charAt(0) == '0'){
            while(sb.length() >1 && sb.charAt(0) == '0') {
                sb.deleteCharAt(0);
                if(sb.length() != 1) sb.deleteCharAt(sb.length()-1);
            }
        }

        //
        if(sb.length() != 0)
            for(int j = 9; j>=0; j--) {
                if( map[j] > 0 ){
                    // 如果长度是奇数，则有可能把中间的替换成更大的数
                    if(sb.length() %2 == 1 ){
                        midchar = sb.charAt(sb.length()/2);  // 找到中间的char
                        if(j > midchar-'0')
                            sb.setCharAt(sb.length()/2, (char)(j + '0'));
                        // 如果长度是偶数，则把落单的数插到中间
                    }else if(sb.length() != 1){
                        sb.insert(sb.length()/2, (char)(j + '0'));
                    }
                    break;
                }
            }

        return sb.toString();
    }

}
