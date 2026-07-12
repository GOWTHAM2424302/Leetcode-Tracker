// Last updated: 7/12/2026, 9:00:41 AM
1class Solution {
2    public int[] arrayRankTransform(int[] arr) {
3        int[] sorted = arr.clone();
4        Arrays.sort(sorted);
5
6        Map<Integer, Integer> map = new HashMap<>();
7        int rank = 1;
8
9        for (int x : sorted) {
10            if (!map.containsKey(x)) {
11                map.put(x, rank++);
12            }
13        }
14
15        int[] ans = new int[arr.length];
16
17        for (int i = 0; i < arr.length; i++) {
18            ans[i] = map.get(arr[i]);
19        }
20
21        return ans;
22    }
23}