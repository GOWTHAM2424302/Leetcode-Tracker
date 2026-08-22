// Last updated: 8/22/2026, 9:30:33 AM
1class Solution {
2    public boolean checkDivisibility(int n) {
3        int num = n, sum=0, prod=1;
4
5        while(n!=0)
6        {
7            int dig = n%10;
8             sum+= dig;
9             prod *= dig;
10             n/=10;
11        }
12        if(num % (sum+prod)==0) return true;
13
14        return false;
15    }
16}