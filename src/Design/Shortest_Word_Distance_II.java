package Design;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 244. Shortest Word Distance II

 每个单词可能有多个位置，找到两个单词相对位置最近的， 用two pinter 分别扫这两个index list。一遍update
 * **/

public class Shortest_Word_Distance_II {
    Map<String, List<Integer>> map = new HashMap();

    public void WordDistance(String[] wordsDict) {
        for(int i = 0; i< wordsDict.length; i++){
            if(!map.containsKey(wordsDict[i])){
                map.put(wordsDict[i], new ArrayList());
            }
            map.get(wordsDict[i]).add(i);
        }
    }

    public int shortest(String word1, String word2) {
        List<Integer> l1 = map.get(word1);
        List<Integer> l2 = map.get(word2);
        int min = 50000;
        int i = 0;
        int j = 0;
        while(i<l1.size() && j<l2.size()){
            int diff = Math.abs(l1.get(i) - l2.get(j));
            if(diff == 0) return 0;
            min = Math.min(diff, min);
            if(l1.get(i) < l2.get(j)){
                i++;
            }else{
                j++;
            }
        }
        return min;
    }
}
