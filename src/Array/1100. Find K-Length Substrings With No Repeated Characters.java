
/**  1100. Find K-Length Substrings With No Repeated Characters
    Sliding window
 **/
class Solution {
    public int numKLenSubstrNoRepeats(String s, int k) {
        Map<Character, Integer> map = new HashMap();
        for(int i = 0; i< k; i++){
            if(i>= s.length()) return 0;
            char c= s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int count = 0;
        if(map.keySet().size() == k) count++;
        for(int i = k; i< s.length(); i++ ){
            char start = s.charAt( i - k );
            char end = s.charAt(i);
            map.put(end, map.getOrDefault(end, 0) + 1);
            map.put(start, map.get(start)-1);
            if(map.get(start) == 0) map.remove(start);
            if(map.keySet().size() == k) count++;
        }
        return count;
    }
}