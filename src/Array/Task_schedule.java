package Array;
/**
 621. Task Scheduler
 However, there is a non-negative integer n that represents the cooldown period between two same tasks
 (the same letter in the array), that is that there must be at least n units of time between any two same tasks.
 * **/
public class Task_schedule {

    // A B ? ? A B ? ? A B
    // partCount = count(A) - 1
    // emptySlots = partCount * (n - (count of tasks with most frequency - 1))
    // availableTasks = tasks.length - count(A) * count of tasks with most frenquency
    // idles = max(0, emptySlots - availableTasks)
    // result = tasks.length + idles
    public int leastInterval(char[] tasks, int n) {
        int[] counter = new int[26];
        int maxcount = 0; // 记录有多少个 task 拥有最高频数
        int max = 0;
        // 找到频数最高的task 的个数
        for(char c : tasks){
            counter[c - 'A']++;
            if(max == counter[c - 'A']){
                maxcount++;
            }
            if(max < counter[c - 'A']){
                max = counter[c - 'A'];
                maxcount = 1;
            }
        }

        int partCount = max -1;
        int partLength = n - (maxcount -1); // 每个小段 未被填上 的位置 "???"的长度
        int emptySlots = partCount * partLength;
        int avaliableTasks = tasks.length - max*maxcount;
        int idles = Math.max(0, emptySlots - avaliableTasks);
        return tasks.length + idles;
    }
}
