// Last updated: 8/19/2026, 7:06:04 AM
1class Solution {
2    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
3        Map<Integer,Set<Integer>> map=new HashMap<>();
4        for(int[] seat:reservedSeats){
5            map.putIfAbsent(seat[0],new HashSet<>());
6            map.get(seat[0]).add(seat[1]);
7        }
8        int ans=(n-map.size())*2;
9        for(Set<Integer> set:map.values()){
10            boolean left=!set.contains(2) && !set.contains(3) && !set.contains(4) && !set.contains(5);
11            boolean middle=!set.contains(4) && !set.contains(5) && !set.contains(6) && !set.contains(7);
12            boolean right=!set.contains(6) && !set.contains(7) && !set.contains(8) && !set.contains(9);
13            if(left && right){
14                ans+=2;
15            }
16            else if(left || middle || right){
17                ans+=1;
18            }
19        }
20        return ans;
21    }
22}