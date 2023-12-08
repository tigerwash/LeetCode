class Solution {
    /** 433 String Compression 的反面题 3[a]2[bc] -》 aaabcbc
     难点在于他这个居然还有nested []
     维护一个curS
     所以只能用stack 做。 而且需压迫两个stack ，一个存 num， 一个存str
     每当碰到 [ 得时候把 当前的 num 和之前的str 各家进stack 然后初始化
     碰到 ] 时就 开始复制str， pop 出num， 和prestr， 按num 来在prestr 后面append curStr

     最后return curS
     */

    public String decodeString(String s) {
        StringBuilder sb = new StringBuilder();
        int curN = 0;
        String curS = "";
        Stack<String> stackStr = new Stack();
        Stack<Integer> stackCt = new Stack();
        int i = 0;
        while(i<s.length()){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                while(Character.isDigit(s.charAt(i))){
                    curN = curN*10+(s.charAt(i)-'0');
                    i++;
                }
            }else if(c == '[') { // 碰到[ 就把 数 和之前的 str 加进去，然后清零
                stackCt.add(curN);
                curN = 0;

                stackStr.add(curS);
                curS = "";
                i++;
            }else if(c == ']') { // 碰到 ] 说明要开始计算复制了，把之前的str pop 出来，在他尾巴上复制
                int num = stackCt.pop();
                String preStr = stackStr.pop();
                while(num>0){
                    preStr += curS;
                    num--;
                }
                curS = preStr;
                i++;
            }else { // a -> z
                curS += c;
                i++;
            }
        }
        return curS;
    }
}