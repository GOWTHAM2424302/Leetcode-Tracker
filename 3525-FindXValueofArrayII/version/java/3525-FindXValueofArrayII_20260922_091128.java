// Last updated: 9/22/2026, 9:11:28 AM
1class Solution {
2    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
3        return rec1[0] < rec2[2] &&
4               rec2[0] < rec1[2] &&
5               rec1[1] < rec2[3] &&
6               rec2[1] < rec1[3];
7    }
8}