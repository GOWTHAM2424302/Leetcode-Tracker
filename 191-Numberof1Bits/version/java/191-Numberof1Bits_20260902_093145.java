// Last updated: 9/2/2026, 9:31:45 AM
1import java.util.*;
2
3class Solution {
4    public int findRadius(int[] houses, int[] heaters) {
5        Arrays.sort(houses);
6        Arrays.sort(heaters);
7
8        int radius = 0;
9
10        for (int house : houses) {
11            int index = Arrays.binarySearch(heaters, house);
12
13            if (index < 0) {
14                index = -index - 1;
15            }
16
17            int leftDistance = index > 0
18                    ? house - heaters[index - 1]
19                    : Integer.MAX_VALUE;
20
21            int rightDistance = index < heaters.length
22                    ? heaters[index] - house
23                    : Integer.MAX_VALUE;
24
25            radius = Math.max(radius, Math.min(leftDistance, rightDistance));
26        }
27
28        return radius;
29    }
30}