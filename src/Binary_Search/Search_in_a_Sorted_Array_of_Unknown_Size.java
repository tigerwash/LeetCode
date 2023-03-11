package Binary_Search;
/**
 * 702. Search in a Sorted Array of Unknown Size
 指数增长找到外界， 再二分法
 * **/
public class Search_in_a_Sorted_Array_of_Unknown_Size {
    public int search(ArrayReader reader, int target) {
        int MAX = (int)2e31;
        // System.out.print(reader.get(10));
        int pivot = 1;
        while(reader.get(pivot) < target) pivot *= 2;
        int l = 0; int r = pivot;
        while(l<r){
            int mid = (r-l)/2+l;
            if(reader.get(mid)<target){
                l = mid+1;
            }else if(reader.get(mid)>target){
                r = mid-1;
            }else{
                return mid;
            }
        }
        return reader.get(l) == target? l : -1;
    }
}
