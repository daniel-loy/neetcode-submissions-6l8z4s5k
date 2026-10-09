
class Twitter {

    int time = 0;
    HashMap<Integer, User> map;

    public class User {

        HashSet<Integer> set = new HashSet<>();
        ArrayList<Point> arr = new ArrayList<>();

        public void follow(int id) {
            set.add(id);
        }

        public void addpost(int tweetid) {
            time++;
            arr.add(new Point(time, tweetid));
        }

        public HashSet<Integer> get() {
            return set;
        }

        public void removefollower(int userid) {
            set.remove(userid);
        }

        public ArrayList<Point> getpost() {
            return arr;
        }
    }

    public class Point {
        int val; // Timestamp
        int key; // Tweet ID

        public Point(int val, int key) {
            this.val = val;
            this.key = key;
        }
    }

    public Twitter() {
        map = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
        User user = map.getOrDefault(userId, new User());

        user.addpost(tweetId);

        map.put(userId, user);
    }

    public List<Integer> getNewsFeed(int userId) {

        List<Integer> result = new ArrayList<>();

        // Min-heap: oldest tweet is at the top
        PriorityQueue<Point> pri = new PriorityQueue<>(
            (a, b) -> Integer.compare(a.val, b.val)
        );

        User user = map.getOrDefault(userId, new User());

        // Include the user's own tweets
        for (Point p : user.getpost()) {
            pri.offer(p);

            if (pri.size() > 10) {
                pri.poll();
            }
        }

        // Include tweets from followed users
        for (int id : user.get()) {

            User followed = map.get(id);

            if (followed == null) {
                continue;
            }

            for (Point p : followed.getpost()) {
                pri.offer(p);

                if (pri.size() > 10) {
                    pri.poll();
                }
            }
        }

        // Extract tweets from oldest to newest
        while (!pri.isEmpty()) {
            result.add(pri.poll().key);
        }

        // Reverse to get newest to oldest
        Collections.reverse(result);

        return result;
    }

    public void follow(int followerId, int followeeId) {

        User user = map.getOrDefault(followerId, new User());
        User user2 = map.getOrDefault(followeeId, new User());

        user.follow(followeeId);

        map.put(followerId, user);
        map.put(followeeId, user2);
    }

    public void unfollow(int followerId, int followeeId) {

        User user = map.get(followerId);

        if (user != null) {
            user.removefollower(followeeId);
        }
    }
}
