// Last updated: 9/1/2026, 9:40:54 AM
1class Solution {
2    public void reorderList(ListNode head) {
3        if (head == null || head.next == null) {
4            return;
5        }
6
7        // Step 1: Find the middle
8        ListNode slow = head;
9        ListNode fast = head;
10
11        while (fast.next != null && fast.next.next != null) {
12            slow = slow.next;
13            fast = fast.next.next;
14        }
15
16        // Step 2: Reverse the second half
17        ListNode second = slow.next;
18        slow.next = null;
19
20        ListNode prev = null;
21
22        while (second != null) {
23            ListNode next = second.next;
24            second.next = prev;
25            prev = second;
26            second = next;
27        }
28
29        // Step 3: Merge both halves
30        ListNode first = head;
31        second = prev;
32
33        while (second != null) {
34            ListNode temp1 = first.next;
35            ListNode temp2 = second.next;
36
37            first.next = second;
38            second.next = temp1;
39
40            first = temp1;
41            second = temp2;
42        }
43    }
44}