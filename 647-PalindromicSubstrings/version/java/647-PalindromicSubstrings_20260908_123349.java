// Last updated: 9/8/2026, 12:33:49 PM
1import java.util.*;
2
3class Solution {
4    public int[] intersect(int[] nums1, int[] nums2) {
5        Map<Integer, Integer> map = new HashMap<>();
6
7        for (int num : nums1) {
8            map.put(num, map.getOrDefault(num, 0) + 1);
9        }
10
11        List<Integer> result = new ArrayList<>();
12
13        for (int num : nums2) {
14            if (map.getOrDefault(num, 0) > 0) {
15                result.add(num);
16                map.put(num, map.get(num) - 1);
17            }
18        }
19
20        int[] answer = new int[result.size()];
21
22        for (int i = 0; i < result.size(); i++) {
23            answer[i] = result.get(i);
24        }
25
26        return answer;
27    }
28}