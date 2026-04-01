
class Twitter {
    int timestamp = 0;

    // userId -> (timestamp -> tweetId)
    HashMap<Integer, HashMap<Integer, Integer>> tweet = new HashMap<>();

    // followerId -> list of followees
    HashMap<Integer, ArrayList<Integer>> followings = new HashMap<>();

    public Twitter() {}

    public void postTweet(int userId, int tweetId) {
        timestamp++;
        tweet.putIfAbsent(userId, new HashMap<>());
        tweet.get(userId).put(timestamp, tweetId);
    }

    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());

        // Add user's own tweets
        if (tweet.containsKey(userId)) {
            heap.addAll(tweet.get(userId).keySet());
        }

        // Add followees' tweets
        if (followings.containsKey(userId)) {
            for (int followeeId : followings.get(userId)) {
                if (tweet.containsKey(followeeId)) {
                    heap.addAll(tweet.get(followeeId).keySet());
                }
            }
        }

        // Collect top 10 most recent tweetIds
        List<Integer> res = new ArrayList<>();
        int count = 0;
        while (!heap.isEmpty() && count < 10) {
            int time = heap.poll();
            // Find which user posted this timestamp
            for (int user : tweet.keySet()) {
                if (tweet.get(user).containsKey(time)) {
                    res.add(tweet.get(user).get(time));
                    break;
                }
            }
            count++;
        }

        return res;
    }

    public void follow(int followerId, int followeeId) {
            if (followerId == followeeId) return; // cannot follow oneself
        followings.putIfAbsent(followerId, new ArrayList<>());
        if (!followings.get(followerId).contains(followeeId)) {
            followings.get(followerId).add(followeeId);
        }
    }

    public void unfollow(int followerId, int followeeId) {
        if (followings.containsKey(followerId)) {
            followings.get(followerId).remove(Integer.valueOf(followeeId));
        }
    }
}
