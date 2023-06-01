import java.util.TreeMap;

class SnapshotArray {
    /**
     * 1146. Snapshot Array
     *
     主要就是构建一个Treemap[] arr,  arr[i] 是一个treemap
     map 里面放<snap_id, val>
     每次snapshoot 时候就把global++；
     set value 的时候把当前的 id 和val 一起放进map
     读取的时候如果map 里面没有这个id，那就读他最后一个id，which is 最新的，(就图这个功能所以得用treemap)
     */

    // array[map<snap id, val>]
    TreeMap<Integer, Integer>[] arr ;
    int global;
    public SnapshotArray(int length) {
        arr = new TreeMap[length];
        global = 0;
        for(int i = 0; i< length; i++){
            arr[i] = new TreeMap<Integer, Integer>();
            arr[i].put(0, 0);
        }
    }

    public void set(int index, int val) {
        arr[index].put(global, val);
    }

    public int snap() {
        global++;
        return global-1;
    }

    public int get(int index, int snap_id) {
        // return Integer.parseInt( arr[index].get(snap_id).toString() );
        return arr[index].floorEntry(snap_id).getValue();
    }
}