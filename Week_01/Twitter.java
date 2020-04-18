package Week_01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

//twitter类 ，时间戳 还有User类的定义
class Twitter {
    
    private static int timestamp = 0;
    private static class Tweet {
        private  int id;
        private  int time;
        private Tweet next;

        public Tweet( int id,  int time) {
            this.id = id;
            this.time = time;
            this.next = null;
        }
    }

    private static class User {
        private  int id;
        public Set<Integer> followed;
        public Tweet head;

        public User( int userid) {
            followed = new HashSet<>();
            this.id = userid;
            this.head = null;

            follow(id);
        }

        public void follow( int userId) {
            followed.add(userId);
        }

        public void unfollow( int userId) {
            if (userId != this.id)
                followed.remove(userId);
        }

        public void post( int tweetId) {
             Tweet twt = new Tweet(tweetId, timestamp);
            timestamp++;

            twt.next = head;
            head = twt;
        }
    }

    private HashMap<Integer, User> userMap = new HashMap<>();

    /** Compose a new tweet. */
    public void postTweet( int userId,  int tweetId) {
        if (!userMap.containsKey(userId))
            userMap.put(userId, new User(userId));

         User user = userMap.get(userId);
        user.post(tweetId);

    }

    /**
     * Retrieve the 10 most recent tweet ids in the user's news feed. Each item in
     * the news feed must be posted by users who the user followed or by the user
     * herself. Tweets must be ordered from most recent to least recent.
     */
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> feeds = new ArrayList<>();
        if (!userMap.containsKey(userId))
            return feeds;

        Set<Integer> users = userMap.get(userId).followed;

         PriorityQueue<Tweet> priorityQueue = new PriorityQueue<>(users.size(), (a, b) -> (b.time - a.time));

        for ( int id : users) {
             Tweet twt = userMap.get(id).head;
            if (twt == null)
                continue;
            priorityQueue.add(twt);
        }

        while (!priorityQueue.isEmpty()) {
            if (feeds.size() == 10)
                break;
             Tweet twt = priorityQueue.poll();
            feeds.add(twt.id);

            if (twt.next != null)
                priorityQueue.add(twt.next);
        }

        return feeds;
    }

    /**
     * Follower follows a followee. If the operation is invalid, it should be a
     * no-op.
     */
    public void follow(int followerId, int followeeId) {
        if (!userMap.containsKey(followerId)) {
            User user = new User(followerId);
            userMap.put(followerId, user);
        }

        if (!userMap.containsKey(followeeId)) {
            User user = new User(followeeId);
            userMap.put(followeeId, user);
        }

        userMap.get(followerId).follow(followeeId);

    }

    /**
     * Follower unfollows a followee. If the operation is invalid, it should be a
     * no-op.
     */
    public void unfollow(int followerId, int followeeId) {
        if (userMap.containsKey(followerId)) {
            User user = userMap.get(followerId);
            user.unfollow(followeeId);
        }
    }

}