// Last updated: 7/17/2026, 9:50:37 AM
1public class Solution {
2    public boolean hasCycle(ListNode head) {
3        if (head == null || head.next == null) {
4            return false;
5        }
6
7        ListNode slow = head;
8        ListNode fast = head;
9
10        while (fast != null && fast.next != null) {
11            slow = slow.next;          // move one step
12            fast = fast.next.next;     // move two steps
13
14            if (slow == fast) {
15                return true;           // cycle detected
16            }
17        }
18
19        return false;                  // no cycle
20    }
21}