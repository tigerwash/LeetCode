/**
 给一个integer stream(latency)，让你只记录前N个integer，然后去除里面最大的K个，算剩下(N - K)个数字的平均值
 sample：5，2，3，3，5，1，5，7 ....
 如果 N = 5， K = 2,  当7进来时，call getAverage(int latency) 返回 3 -> （3 + 5 + 1）/ 3
 可以考虑用两个heap 或者sortedList(python), multiset(C++), 或者类似balanced bst的结构
 * **/