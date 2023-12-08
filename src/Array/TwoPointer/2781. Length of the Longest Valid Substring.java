class Solution {
    /**
     这个核心点在于 forbidden word  的长度一定小于10， 所以我们每次check 是否
     为forbidden word 的时候只要每次往后扫十个位置就好。
     所以还是要两个pointer： l, r
     这个样对一个window:  l <---> r, 在引入一个从左到右扫的i，只需查找每次以i 开头的substring（10个位置内）
     是否为不好的substring，如果是forbidden， 那么去掉最后一个尾巴字母， l <---> i-1 肯定是一个好的substring
     计算他的长度， 同时 r 更新为 i-1, 带入下一个循环
     */
    public int longestValidSubstring(String word, List<String> forbidden) {
        Set<String> set = new HashSet();
        for(String w : forbidden) set.add(w);
        int max = 0;
        int right = word.length()-1;
        for(int left = word.length()-1; left>=0; left--) {
            for(int i = left; i<Math.min(left+10, right+1); i++) {
                String substr = word.substring(left, i+1);
                if(set.contains(substr)) {
                    right = i-1;
                    break;
                }
            }
            max = Math.max(max, right - left+1);
        }
        return max;
    }
}