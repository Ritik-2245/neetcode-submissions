// import java.util.*;

class Twitter {

    static class User{
        TreeSet<Integer> followee;
        List<int[]> tweets;
          User(int userId){
            followee = new TreeSet<>();
            tweets = new ArrayList<>();
            followee.add(userId);
          }
    }

    private Map<Integer,User> data;
    private int time=0;

    public Twitter() {
        data = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        setUser(userId);
        data.get(userId).tweets.add(new int[]{time++,tweetId});
    }
    
    public List<Integer> getNewsFeed(int userId) {
        setUser(userId);
        PriorityQueue<int[]> posts = new PriorityQueue<>((a,b)->Integer.compare(a[0],b[0]));
        
        for(int i:data.get(userId).followee){
         addPost(i, posts);
        }

// List<Integer> ans = posts.stream().map(post->post[1]).collect(Collectors.toList());
// List<Integer> ans = new ArrayList<>();
// while(!posts.isEmpty())ans.add(posts.poll()[1]);
List<Integer> ans = posts.stream().sorted((a, b) -> Integer.compare(a[0], b[0])).map(post->post[1]).collect(Collectors.toList());
         Collections.reverse(ans);
         return ans;
    }

    private void addPost(int userId,PriorityQueue<int[]> posts){
        List<int[]> tweeList = data.get(userId).tweets;
          
          for(int i=tweeList.size()-1;i>=Math.max(0,tweeList.size()-10-1);i--){
            posts.offer(tweeList.get(i));
            if(posts.size()>10)posts.poll();
          }

         
            }

private void setUser(int userId){
    if(!data.containsKey(userId))
        data.put(userId, new User(userId));
}
    


    public void follow(int followerId, int followeeId) {
        setUser(followerId);
        setUser(followeeId);
          data.get(followerId).followee.add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(followerId==followeeId)return;
         data.get(followerId).followee.remove(followeeId);
    }
}
