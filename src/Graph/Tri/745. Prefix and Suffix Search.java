

/***
 * 745. Prefix and Suffix Search
 *
 求一个一堆words 里面有哪个word 符合， prefix *** sufix 的pattern
 建两个tri， 一个prefix tri, 一个sufix tri, 同时每个tri node 中要有set 包含所有符合这个node 的单词，
 这样可以分别直接找出满足 prefix 和 sufix 的words， 然后找这两个set 的交集。
 */


class WordFilter {

    // 每个node 中需要有Set<String> 来存符合这个pattern 的所有words
    class TriNode {
        Character c;
        Map<Character, TriNode> children;
        Set<String> words ;
        TriNode (Character c) {
            this.c = c;
            children = new HashMap();
            words = new HashSet();
        }

    }
    // build preTri and sufTri at the same time
    TriNode preN, sufN;
    Map<String, Integer> map; // <word, index>
    public WordFilter(String[] words) {
        map = new HashMap();
        preN = new TriNode('-');
        sufN = new TriNode('-');

        for(int k = 0; k<words.length; k++) {
            TriNode curPre = preN;
            TriNode curSuf = sufN;
            String word = words[k];
            map.put(word, k);
            int len = word.length();
            for(int i = 0; i<len; i++) {
                // build pre Tri
                char cp = word.charAt(i);
                if(!curPre.children.containsKey(cp)) {
                    TriNode node = new TriNode(cp);
                    curPre.children.put(cp, node);
                }

                curPre = curPre.children.get(cp);
                curPre.words.add(word);

                // build suf Tri
                char cs = word.charAt(len-1-i);
                if(!curSuf.children.containsKey(cs)) {
                    TriNode node = new TriNode(cs);
                    curSuf.children.put(cs, node);
                }

                curSuf = curSuf.children.get(cs);
                curSuf.words.add(word);
            }
        }

    }

    public int f(String pref, String suff) {
        // find words from pre Tri
        TriNode curPre = preN;
        for(char c : pref.toCharArray()) {
            if(curPre.children.containsKey(c)) {
                curPre = curPre.children.get(c);
            }else {
                return -1;
            }
        }
        // words has pref as prefix
        Set<String> preWords = curPre.words;

        // find words from suf Tri
        TriNode curSuf = sufN;
        for(int i = suff.length()-1; i>=0; i--) {
            char c = suff.charAt(i);
            if(curSuf.children.containsKey(c)) {

                curSuf = curSuf.children.get(c);
            }else {
                return -1;
            }
        }
        // words has suf as suffix
        Set<String> sufWords = curSuf.words;

        int index = -1;
        for(String w : preWords) {
            if(sufWords.contains(w)) {
                index = Math.max(map.get(w), index);
            }
        }
        return index;
    }
}

/**
 * Your WordFilter object will be instantiated and called as such:
 * WordFilter obj = new WordFilter(words);
 * int param_1 = obj.f(pref,suff);
 */