class Twitter {

    private static int time = 0;

    // userId -> tweets
    private Map<Integer, List<Tweet>> tweetMap;
    // userId -> followees
    private Map<Integer, Set<Integer>> followMap;

    public Twitter() {
        tweetMap = new HashMap<>();
        followMap = new HashMap<>();
    }

    // ---------- POST TWEET ----------
    public void postTweet(int userId, int tweetId) {
        tweetMap
            .computeIfAbsent(userId, k -> new ArrayList<>())
            .add(new Tweet(tweetId, time++));
    }

    // ---------- GET NEWS FEED ----------
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> result = new ArrayList<>();

        PriorityQueue<Node> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(b.time, a.time) // max heap
        );

        // user follows themself
        followMap.computeIfAbsent(userId, k -> new HashSet<>()).add(userId);

        for (int followee : followMap.get(userId)) {
            List<Tweet> tweets = tweetMap.get(followee);
            if (tweets != null && !tweets.isEmpty()) {
                int lastIndex = tweets.size() - 1;
                Tweet t = tweets.get(lastIndex);
                pq.offer(new Node(t.tweetId, t.time, followee, lastIndex));
            }
        }

        while (!pq.isEmpty() && result.size() < 10) {
            Node node = pq.poll();
            result.add(node.tweetId);

            if (node.index > 0) {
                Tweet next = tweetMap.get(node.userId).get(node.index - 1);
                pq.offer(new Node(next.tweetId, next.time,
                                  node.userId, node.index - 1));
            }
        }

        return result;
    }

    // ---------- FOLLOW ----------
    public void follow(int followerId, int followeeId) {
        followMap
            .computeIfAbsent(followerId, k -> new HashSet<>())
            .add(followeeId);
    }

    // ---------- UNFOLLOW ----------
    public void unfollow(int followerId, int followeeId) {
        if (followMap.containsKey(followerId) && followerId != followeeId) {
            followMap.get(followerId).remove(followeeId);
        }
    }

    // ---------- HELPER CLASSES ----------
    static class Tweet {
        int tweetId;
        int time;
        Tweet(int id, int time) {
            this.tweetId = id;
            this.time = time;
        }
    }

    static class Node {
        int tweetId;
        int time;
        int userId;
        int index;
        Node(int tId, int time, int userId, int idx) {
            this.tweetId = tId;
            this.time = time;
            this.userId = userId;
            this.index = idx;
        }
    }
}
