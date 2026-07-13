// Last updated: 7/13/2026, 12:28:44 PM
1class Solution {
2    public ListNode reverseBetween(ListNode head, int left, int right) {
3        if (head == null || left == right) return head;
4
5        ListNode dummy = new ListNode(0);
6        dummy.next = head;
7        ListNode prev = dummy;
8
9        for (int i = 1; i < left; i++) {
10            prev = prev.next;
11        }
12
13        ListNode curr = prev.next;
14
15        for (int i = 0; i < right - left; i++) {
16            ListNode next = curr.next;
17            curr.next = next.next;
18            next.next = prev.next;
19            prev.next = next;
20        }
21
22        return dummy.next;
23    }
24}