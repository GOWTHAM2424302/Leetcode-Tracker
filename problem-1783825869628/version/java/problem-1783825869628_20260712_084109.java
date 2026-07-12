// Last updated: 7/12/2026, 8:41:09 AM
1class Solution {
2    public int secondsBetweenTimes(String startTime, String endTime) {
3        return toSeconds(endTime)-toSeconds(startTime);
4    }
5    private int toSeconds(String time){
6        String[]t=time.split(":");
7        int h=Integer.parseInt(t[0]);
8        int m=Integer.parseInt(t[1]);
9        int s=Integer.parseInt(t[2]);
10
11        return h*3600+m*60+s;
12    }
13}