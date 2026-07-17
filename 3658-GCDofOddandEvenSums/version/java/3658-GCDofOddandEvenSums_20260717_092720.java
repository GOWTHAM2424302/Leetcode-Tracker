// Last updated: 7/17/2026, 9:27:20 AM
1class Solution {
2    public int gcdOfOddEvenSums(int n) {
3        int sumOdd = n * n;           // Sum of first n odd numbers
4        int sumEven = n * (n + 1);    // Sum of first n even numbers
5
6        return gcd(sumOdd, sumEven);
7    }
8
9    private int gcd(int a, int b) {
10        while (b != 0) {
11            int temp = b;
12            b = a % b;
13            a = temp;
14        }
15        return a;
16    }
17}