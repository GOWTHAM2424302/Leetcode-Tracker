// Last updated: 9/8/2026, 10:26:13 AM
1class Solution {
2    public int magicalString(int n) {
3        if (n == 0) return 0;
4        if (n <= 3) return 1;
5
6        int[] arr = new int[n + 2];
7
8        arr[0] = 1;
9        arr[1] = 2;
10        arr[2] = 2;
11
12        int head = 2;
13        int tail = 3;
14        int num = 1;
15        int count = 1;
16
17        while (tail < n) {
18            int repeat = arr[head];
19
20            for (int i = 0; i < repeat && tail < n; i++) {
21                arr[tail] = num;
22
23                if (num == 1) {
24                    count++;
25                }
26
27                tail++;
28            }
29
30            num = 3 - num; // Switch between 1 and 2
31            head++;
32        }
33
34        return count;
35    }
36}