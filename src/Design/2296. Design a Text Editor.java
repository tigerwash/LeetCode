class TextEditor {
    //  直接用sb， sb.substring(l, r);
    StringBuilder sb;
    int cur;
    public TextEditor() {
        sb = new StringBuilder();
        cur = 0;
    }

    public void addText(String text) {
        sb.insert(cur,text);
        cur += text.length();
    }

    public int deleteText(int k) {
        int l = Math.max(0, cur-k);
        int r = cur;
        sb.delete(l, cur);
        cur = l;
        return r - l;
    }

    public String cursorLeft(int k) {
        int start = Math.max(0, cur - k);
        cur = start;
        int l = Math.max(0, cur - 10);
        return sb.substring(l, cur);
    }

    public String cursorRight(int k) {
        int start = Math.min(sb.length(), cur + k);
        cur = start;
        int l = Math.max(0, cur - 10);
        return sb.substring(l, cur);
    }
}
