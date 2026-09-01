// Last updated: 9/1/2026, 10:35:05 PM
1import java.util.*;
2
3class MyCalendarThree {
4
5    private TreeMap<Integer, Integer> map;
6
7    public MyCalendarThree() {
8        map = new TreeMap<>();
9    }
10
11    public int book(int startTime, int endTime) {
12
13        map.put(startTime, map.getOrDefault(startTime, 0) + 1);
14        map.put(endTime, map.getOrDefault(endTime, 0) - 1);
15
16        int active = 0;
17        int max = 0;
18
19        for (int value : map.values()) {
20            active += value;
21            max = Math.max(max, active);
22        }
23
24        return max;
25    }
26}