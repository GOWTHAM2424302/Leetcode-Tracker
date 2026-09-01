// Last updated: 9/1/2026, 10:34:27 PM
1import java.util.*;
2
3class MyCalendarTwo {
4
5    private List<int[]> bookings;
6    private List<int[]> overlaps;
7
8    public MyCalendarTwo() {
9        bookings = new ArrayList<>();
10        overlaps = new ArrayList<>();
11    }
12
13    public boolean book(int startTime, int endTime) {
14
15        // Check if this booking creates a triple booking
16        for (int[] overlap : overlaps) {
17            if (Math.max(startTime, overlap[0]) < Math.min(endTime, overlap[1])) {
18                return false;
19            }
20        }
21
22        // Find overlaps with existing bookings
23        for (int[] booking : bookings) {
24            int start = Math.max(startTime, booking[0]);
25            int end = Math.min(endTime, booking[1]);
26
27            if (start < end) {
28                overlaps.add(new int[]{start, end});
29            }
30        }
31
32        // Add the booking
33        bookings.add(new int[]{startTime, endTime});
34
35        return true;
36    }
37}