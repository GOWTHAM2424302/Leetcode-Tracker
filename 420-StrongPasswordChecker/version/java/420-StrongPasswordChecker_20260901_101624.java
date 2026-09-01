// Last updated: 9/1/2026, 10:16:24 AM
1class Solution {
2
3    public int reversePairs(int[] nums) {
4        return mergeSort(nums, 0, nums.length - 1);
5    }
6
7    private int mergeSort(int[] nums, int left, int right) {
8        if (left >= right) {
9            return 0;
10        }
11
12        int mid = left + (right - left) / 2;
13
14        int count = mergeSort(nums, left, mid)
15                  + mergeSort(nums, mid + 1, right);
16
17        int j = mid + 1;
18
19        // Count reverse pairs
20        for (int i = left; i <= mid; i++) {
21            while (j <= right && (long) nums[i] > 2L * nums[j]) {
22                j++;
23            }
24
25            count += j - (mid + 1);
26        }
27
28        // Merge sorted halves
29        int[] temp = new int[right - left + 1];
30
31        int i = left;
32        j = mid + 1;
33        int k = 0;
34
35        while (i <= mid && j <= right) {
36            if (nums[i] <= nums[j]) {
37                temp[k++] = nums[i++];
38            } else {
39                temp[k++] = nums[j++];
40            }
41        }
42
43        while (i <= mid) {
44            temp[k++] = nums[i++];
45        }
46
47        while (j <= right) {
48            temp[k++] = nums[j++];
49        }
50
51        for (i = left, k = 0; i <= right; i++, k++) {
52            nums[i] = temp[k];
53        }
54
55        return count;
56    }
57}