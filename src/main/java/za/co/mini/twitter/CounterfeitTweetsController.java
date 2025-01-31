package za.co.mini.twitter;

import java.io.IOException;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import za.co.twitter.entity.User;
import za.co.twitter.repository.TweetRepository;
import za.co.twitter.repository.UserRepository;
import za.co.twitter.entity.Tweet;

/**
 *
 * @author Arthur Gwatidzo
 */
public class CounterfeitTweetsController {
	
	
	  private Map<String,User> users = new TreeMap<>();
	    private Set<Tweet> tweets = new LinkedHashSet<>();
	    
	    /**
	     * Method that controls the (very procedural) demonstration of the twitter-like feed
	     * Since this time we are going to watch the console, allowing the IO errors to bubble up
	     * @throws java.io.IOException let IO errors bubble up the call stack
	     */
	    public void fireTweets() throws IOException{
	        
	        UserRepository userRepo = new UserRepository();
	        users = userRepo.getUsers();
	        TweetRepository tweetRepo = new TweetRepository();
	        tweets = tweetRepo.getTweets();
	        applyTweetsToUsers();
	        writeUserTweetFeeds();
	        
	    }
	    
	    /**
	     * publish the tweets to the relevant user feeds 
	     */
	    private void applyTweetsToUsers() {
	        for (Tweet tweet : tweets) {
	            if (users.containsKey(tweet.getUserName())) {
	                users.get(tweet.getUserName()).addTweet(tweet);
	                for (String follower : users.get(tweet.getUserName()).getFollowers()) {
	                   users.get(follower).addTweet(tweet);
	                }
	            }
	        }
	    }
	    
	    /**
	     * Print the current state to the, showcasing the twitter-like feed
	     */
	    private void writeUserTweetFeeds() {
	        for (Map.Entry<String,User> entry : users.entrySet()) {
	            User user = entry.getValue();
	            System.out.println(user.getName());
	            System.out.println("");
	            for (Tweet tweet : user.getFeedHistory()) {
	                System.out.println("        @" + tweet.getUserName() + ": " + tweet.getText());
	                System.out.println("");
	            }
	        }
	    }

}
