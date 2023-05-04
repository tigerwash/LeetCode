package Array;
import java.util.*;


/**
616. Add Bold Tag in String
 Input: s = "abcxyz123", words = ["abc","123"]
 Output: "<b>abc</b>xyz<b>123</b>"

 1. bold[] 标记要bold 的idx, 扫一遍s, 对于每个[i..i+len]
    都看他是不是在set里，如果是的话就把这一段全标为 bold
 2. build string based on bold[]
 */
public class Add_Bold_Tag_in_String {
    public String addBoldTag(String s, String[] words) {
        // bold 标记要bold 的idx
        boolean[] bold = new boolean[s.length()];
        Set<String> set = new HashSet();
        for(String w : words) set.add(w);

        // 扫一遍s, 对于每个[i..i+len] 都看他是不是在set里，如果是的话就把这一段全标为 bold
        for(String word : words){
            int len = word.length();
            for(int i = 0; i<=s.length() - len; i++){
                String curw = s.substring(i, i+len);
                if(set.contains(curw)){
                    for(int j = i; j<i+len; j++) bold[j] = true;
                }
            }
        }

        // build string based on bold[]
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<s.length(); i++){
            if(!bold[i]){
                sb.append(s.charAt(i));
            }else{
                sb.append("<b>");
                while(i<bold.length && bold[i]){
                    sb.append(s.charAt(i++));
                }
                i--;
                sb.append("</b>");
            }
        }
        return sb.toString();
    }
}
