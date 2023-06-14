/**
 * 1087. Brace Expansion
 * 括号里的展开
 * Input: s = "{a,b}c{d,e}f"
 * Output: ["acdf","acef","bcdf","bcef"]
 * **/


class Solution {
    public String[] expand(String s) {
        StringBuilder sb = new StringBuilder();
        List<String> res = new ArrayList();
        dfs(res, s, sb, 0);
        String[] out = new String[res.size()];
        int i = 0;
        while(i<out.length) {
            out[i] = res.get(i);
            i++;
        }
        Arrays.sort(out);
        return out;
    }

    private void dfs(List<String> res, String s, StringBuilder sb, int index) {
        if(index == s.length()) {
            res.add(sb.toString());
            return;
        }
        char cur = s.charAt(index);
        if(cur == '{') {
            int start = index;
            while(s.charAt(index) != '}') {
                index++;
            }
            String[] curlevel = s.substring(start+1, index).split(",");
            for(String str : curlevel) {
                sb.append(str);
                dfs(res, s, sb, index+1);
                sb.deleteCharAt(sb.length() -1);
            }
        }else {
            sb.append(cur);
            dfs(res, s, sb, index+1);
            sb.deleteCharAt(sb.length() -1);
        }
    }
}