// Last updated: 9/1/2026, 10:33:55 PM
1import java.util.*;
2
3class MyCalendar {
4
5    private List<int[]> bookings;
6
7    public MyCalendar() {
8        bookings = new ArrayList<>();
9    }
10
11    public boolean book(int startTime, int endTime) {
12
13        for (int[] booking : bookings) {
14            int start = booking[0];
15            int end = booking[1];
16
17            // Check overlap
18            if (Math.max(startTime, start) < Math.min(endTime, end)) {
19                return false;
20            }
21        }
22
23        bookings.add(new int[]{startTime, endTime});
24
25        return true;
26    }
27}