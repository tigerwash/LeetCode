class Solution(object):
    def makeConnected(self, n, connections):
        """
        :type n: int
        :type connections: List[List[int]]
        :rtype: int
        """
        if len(connections) < n-1: return -1;
        map = []
        for i in range(0, n):
            map.append(i)
        cnt = 0;
        for edge in connections:
            l = edge[0]
            r = edge[1]
            rootL = self.find(map,l)
            rootR = self.find(map, r)
            if rootL != rootR:
                cnt+=1
                map[rootL] = rootR

        group = n - cnt
        return group-1;

    def find(self, map, i):
        while map[i] != i:
            i = map[i]
        return i