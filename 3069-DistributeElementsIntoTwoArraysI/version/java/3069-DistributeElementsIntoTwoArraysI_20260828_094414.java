// Last updated: 8/28/2026, 9:44:14 AM
1class Solution {
2    public int[] resultArray(int[] nums) {
3        int[] arr1 = new int[nums.length];
4        int[] arr2 = new int[nums.length];
5
6        int size1 = 1;
7        int size2 = 1;
8
9        arr1[0] = nums[0];
10
11        arr2[0] = nums[1];
12
13        for (int i = 2; i < nums.length; i++) {
14            if (arr1[size1 - 1] > arr2[size2 - 1]) {
15                arr1[size1++] = nums[i];
16            } else {
17                arr2[size2++] = nums[i];
18            }
19        }
20
21        int[] result = new int[nums.length];
22
23        System.arraycopy(arr1, 0, result, 0, size1);
24
25        System.arraycopy(arr2, 0, result, size1, size2);
26
27        return result;
28    }
29}