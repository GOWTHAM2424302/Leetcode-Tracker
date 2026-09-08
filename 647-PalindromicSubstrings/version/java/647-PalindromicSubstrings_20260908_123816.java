// Last updated: 9/8/2026, 12:38:16 PM
1class Solution {
2    public boolean canCross(int[] stones) {
3        int n = stones.length;
4
5        if (n < 2 || stones[1] != 1) {
6            return n == 1;
7        }
8
9        java.util.Map<Integer, java.util.Set<Integer>> map =
10                new java.util.HashMap<>();
11
12        for (int stone : stones) {
13            map.put(stone, new java.util.HashSet<>());
14        }
15
16        map.get(0).add(0);
17
18        for (int stone : stones) {
19            for (int jump : map.get(stone)) {
20
21                for (int nextJump = jump - 1;
22                     nextJump <= jump + 1;
23                     nextJump++) {
24
25                    if (nextJump <= 0) {
26                        continue;
27                    }
28
29                    int nextStone = stone + nextJump;
30
31                    if (map.containsKey(nextStone)) {
32                        map.get(nextStone).add(nextJump);
33                    }
34                }
35            }
36        }
37
38        return !map.get(stones[n - 1]).isEmpty();
39    }
40}