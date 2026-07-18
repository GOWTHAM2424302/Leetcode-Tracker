// Last updated: 7/18/2026, 8:47:05 PM
1class Solution {
2    public String rearrangeString(String s, char x, char y) {
3     StringBuilder before = new StringBuilder();
4        StringBuilder yPart = new StringBuilder();
5        StringBuilder xPart = new StringBuilder();
6
7        for(char c:s.toCharArray()){
8            if(c==y){
9                yPart.append(c);
10            }else if(c == x){
11                xPart.append(c);
12            }else{
13                before.append(c);
14            }
15            
16        }
17        return before.toString() + yPart.toString()  + xPart.toString();
18    }
19}