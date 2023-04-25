package Math;

/**
 172. Factorial Trailing Zeroes

  求阶乘的结果末尾一共有多少个0

 简单方法是对于每个因数， 判断他有多少个5 作为因数，然后叠加起来。这个做法比较耗时， nlogn

 优化办法是直接算他有多少个5的平方数作为因数，具体可看解析
 https://leetcode.com/problems/factorial-trailing-zeroes/discuss/52373/Simple-CC%2B%2B-Solution-(with-detailed-explaination)
 *
 * **/
public class Factorial_Trailing_Zeroes {
    public int trailingZeroes(int n) {
        int res = 0;
        // int two = 0;
        // int five = 0;
//         for(int i = 2; i<= n; i++){

//             int twoi = i;
//             int fivei = i;
//             // while(twoi%2==0 && twoi>=2){
//             //     two++;
//             //     twoi /= 2;
//             // }
//             while(fivei%5==0 && fivei>=5){
//                 five++;
//                 fivei /= 5;
//             }
//         }

        int i = 5;
        while(i<= n){
            res += n/i;
            i *= 5;
        }
        return res;
    }
}
