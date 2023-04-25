package Array;

/**
 2337. Move Pieces to Obtain a String
L 代表可以左走，R代表可以往右走，求最后 start 是不是可以match 到 target

 Input: start = "_L__R__R_", target = "L______RR"
 Output: true

 Input: start = "R_L_", target = "__LR"
 Output: false

用两个指针i j 分别位于 start 和 target 上。略过所有的 _
 如果 都指向R 的时候，指针不能往左移，所以 i 必须要小等于 j
 如果 都指向L 的时候，指针不能往右移，所以 i 必须要大等于 j

 * **/
public class Move_Pieces_to_Obtain_a_String {

    public boolean canChange(String start, String target) {
        int i = 0;
        int j = 0;
        while(i<start.length() && j < target.length()){
            while(i<start.length() && start.charAt(i) == '_') i++;
            while(j < target.length() && target.charAt(j) == '_') j++;
            if(i == start.length() || j == target.length()) break;

            if(start.charAt(i) != target.charAt(j)) return false;
            if(start.charAt(i) == 'R'){
                if(i > j) return false;
            }
            if(start.charAt(i) == 'L'){
                if(i<j) return false;
            }
            i++;
            j++;
        }

        while(i<start.length() && start.charAt(i) == '_') i++;
        while(j < target.length() && target.charAt(j) == '_') j++;
        return i == start.length() && j == target.length();
    }
}
