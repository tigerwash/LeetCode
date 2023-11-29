class Solution {
    public boolean closeStrings(String word1, String word2) {
        if(word1.length() != word2.length()) return false;
        // 1. occurance number is same
        // 2. characters are teh same
        int[] dic1 = new int[26];
        int[] dic2 = new int[26];
        PriorityQueue<Integer> q1 = new PriorityQueue<Integer>();
        PriorityQueue<Integer> q2 = new PriorityQueue<Integer>();
        for(char c : word1.toCharArray()){
            dic1[c-'a']++;
        }
        for(char c : word2.toCharArray()){
            dic2[c-'a']++;
        }
        for(int i = 0; i<26; i++){
            if(dic1[i]>0){
                if(dic2[i]==0) return false;
                q1.add(dic1[i]);
                q2.add(dic2[i]);
            }
        }
        while(!q1.isEmpty()) {
            int n1 = q1.poll();
            int n2 = q2.poll();
            if(n1!=n2) {
                return false;
            }
        }
        return q2.isEmpty();
    }
}