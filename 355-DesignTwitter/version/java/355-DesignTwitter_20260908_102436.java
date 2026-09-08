// Last updated: 9/8/2026, 10:24:36 AM
1import java.util.*;
2
3class Twitter {
4
5    private static int time = 0;
6
7    private Map<Integer, Set<Integer>> following;
8    private Map<Integer, List<Tweet>> tweets;
9
10    class Tweet {
11        int tweetId;
12        int time;
13
14        Tweet(int tweetId, int time) {
15            this.tweetId = tweetId;
16            this.time = time;
17        }
18    }
19
20    public Twitter() {
21        following = new HashMap<>();
22        tweets = new HashMap<>();
23    }
24
25    public void postTweet(int userId, int tweetId) {
26        tweets.putIfAbsent(userId, new ArrayList<>());
27        tweets.get(userId).add(new Tweet(tweetId, time++));
28    }
29
30    public List<Integer> getNewsFeed(int userId) {
31        PriorityQueue<Tweet> pq = new PriorityQueue<>(
32            (a, b) -> b.time - a.time
33        );
34
35        // Add user's own tweets
36        if (tweets.containsKey(userId)) {
37            pq.addAll(tweets.get(userId));
38        }
39
40        // Add followed users' tweets
41        if (following.containsKey(userId)) {
42            for (int followeeId : following.get(userId)) {
43                if (tweets.containsKey(followeeId)) {
44                    pq.addAll(tweets.get(followeeId));
45                }
46            }
47        }
48
49        List<Integer> result = new ArrayList<>();
50
51        while (!pq.isEmpty() && result.size() < 10) {
52            result.add(pq.poll().tweetId);
53        }
54
55        return result;
56    }
57
58    public void follow(int followerId, int followeeId) {
59        if (followerId == followeeId) {
60            return;
61        }
62
63        following.putIfAbsent(followerId, new HashSet<>());
64        following.get(followerId).add(followeeId);
65    }
66
67    public void unfollow(int followerId, int followeeId) {
68        if (following.containsKey(followerId)) {
69            following.get(followerId).remove(followeeId);
70        }
71    }
72}