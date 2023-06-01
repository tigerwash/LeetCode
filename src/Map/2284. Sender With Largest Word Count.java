import java.util.*;
/**
 * 2284. Sender With Largest Word Count
 * 用一个map 存<名字，字数>
 * 边走边更新 */
class Solution {
    public String largestWordCount(String[] messages, String[] senders) {
        // <name, wordcount>
        Map<String, Integer> map = new HashMap();
        int max = 0;
        String res = "";
        for(int i = 0; i< messages.length; i++) {
            String[] mg = messages[i].split(" ");
            String name = senders[i];
            int count = mg.length;
            map.put(name, map.getOrDefault(name, 0) + count);
            if(max == map.get(name)){
                res = res.compareTo(name) < 0 ? name : res;
            }else if(max < map.get(name)){
                max = map.get(name);
                res = name;
            }
        }
        return res;
    }
}