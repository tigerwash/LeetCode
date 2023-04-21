package Binary_Search;
/**
 2594. Minimum Time to Repair Cars

 // time = r * n^2
 // car : n = sqrt(time / r )
 // 这个time 是唯一的因为 在这个时间内所有的人都在同时修车
 // 所以在固定的time 下 每一个 r 我们扫过去，他能修的车是固定的
 // 扫过去得到的 n 的总和，即为总 car 数
 // 因此我们可以以car 为参照，time为变量，car为判定因素
 // 进行binary search
 * */
public class Minimum_Time_to_Repair_Cars {
    public long repairCars(int[] ranks, int cars) {
        long l = 1;
        // 如果只让一个人修车，那他时间肯定花的最多，任意一个人都一样
        long r = 1L * ranks[0] * cars * cars; //1L * x = (long)x
        while(l < r){
            long mid = (r - l)/2 + l;
            long sum = 0;
            for(int ra : ranks){
                long curcar = (long)(Math.sqrt((1.0)*mid / ra));
                sum += curcar;
            }
            if(sum >= cars){
                r = mid;
            }else {
                l = mid+1;
            }
        }
        return l;

    }
}
