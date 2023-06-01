package Array.Sort;

import java.util.*;



/** 347. Top K Frequent Elements

 *      求频率最高的k 个数
 *      可以用 quick select ， 也可以用priorique，事实上pq速度还快一些
 * */
class Solution {
    Map<Integer, Integer> map;
    public int[] topKFrequent(int[] nums, int k) {
        map = new HashMap<>();
        for(int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        Map<Integer, Integer> see = map;
        int[] arr = new int[map.keySet().size()];
        int j = 0;
        for(int n : map.keySet()) arr[j++] = n;
        quickselect(arr, 0, arr.length-1);
        return Arrays.copyOfRange(arr, 0, k);
    }
    // sort -> descreasing
    public int partition(int[] arr, int left, int right, int pivotIndex) {
        if(left >= right) return left;
        int fast = left;
        int pivot = arr[pivotIndex];
        while(fast < right) {
            while(fast<right){
                if(map.get(arr[fast]) > map.get(pivot)){
                    swap(arr, left++, fast);
                }
                fast++;
            }
        }
        swap(arr,right, left );
        return left;
    }

    public void quickselect(int[] arr, int l, int r) {
        if(l >= r ) return;
        int partitionidx = partition(arr, l, r, r);
        quickselect(arr, l, partitionidx-1);
        quickselect(arr, partitionidx+1, r);
        return;
    }

    private void swap(int[] arr, int l, int r) {
        int tmp = arr[l];
        arr[l] = arr[r];
        arr[r] = tmp;
    }
}

/**       用heap 做    */
class Solution2 {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int n : nums){
            map.put(n, map.getOrDefault(n, 0)+1);
        }
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>(k, new Comparator<Integer>(){
            @Override
            public int compare(Integer a, Integer b){
                return map.get(a) - map.get(b);
            }
        });
        int count = k;
        for(int n : map.keySet()){
            if(count>0){
                heap.offer(n);
            }else{
                heap.offer(n);
                heap.poll();
            }
            count--;
        }
        int[] res = new int[k];
        int i= 0;
        while(!heap.isEmpty()){
            res[i] = heap.poll();
            i++;
        }
        return res;
    }
}