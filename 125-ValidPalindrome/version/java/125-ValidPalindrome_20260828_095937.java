// Last updated: 8/28/2026, 9:59:37 AM
1class Solution {
2    public boolean isPalindrome(String s) {
3        String str="";
4
5for(int i=0;i<s.length();i++)
6{
7    if(Character.isLetterOrDigit(s.charAt(i))) str+=s.charAt(i);
8}
9
10str=str.toLowerCase();
11
12int j=str.length()-1;
13
14for(int i=0;i<str.length()/2;i++)
15{
16    if(str.charAt(i)!=str.charAt(j)){
17        return false;
18    } 
19    
20    j--;
21}
22
23return true;
24    }
25}