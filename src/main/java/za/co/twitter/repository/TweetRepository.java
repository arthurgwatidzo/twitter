package za.co.twitter.repository;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import za.co.mini.twitter.TwitterMainAppController;
import za.co.twitter.entity.Tweet;


/**
 *
 * @author Arthur Gwatidzo
 */
public class TweetRepository {
    
    private List<String> list = new ArrayList<String>();
    private String filePath;
    
    /**
     * Constructs the tweet repository, by default using the (test) file in the resources of the project
     * @throws IOException let IO errors bubble up the call stack
     */
    public TweetRepository() throws IOException {
        this.filePath = "tweet.txt";
        readTweetRepository();
    }
    
    /**
     * Constructs the tweet repository overloaded with file location parameter
     * @param path of the tweet file based repository
     * @throws IOException let IO errors bubble up the call stack
     */
    public TweetRepository(String path) throws IOException {
       this.filePath = path;
       readTweetRepository(); 
    }
    
    private void readTweetRepository() {
        //Read all tweets from the twitter.txt file
        try (Stream<String> tweetLines = Files.lines(Paths.get(TwitterMainAppController.tweetFileName))) {
                list = tweetLines.collect(Collectors.toList());
                //System.out.println("Read all tweets");
                //tweetLines.forEach(System.out::println);
                tweetLines.close();
        } catch (IOException e) {
            //when this repo fails, throw the error back to caller
           
        }
    }
    
    /**
     * Strips the tweets out of their text format and ignores any malformed lines
     * @return the tweets, in chronological order from the repository
     */
    public Set<Tweet> getTweets() {
        Set<Tweet> tweets = new LinkedHashSet<>();
        for (String tweetInput : list) {
            int split = tweetInput.indexOf("> ");
            //strip out the user and the tweet - ignoring malformed lines
            if (split > 0 && tweetInput.length() > split + 2) {
                tweets.add(new Tweet(tweetInput.substring(0,split), tweetInput.substring(split+2)));
            }   
        }
        return tweets;
    }  
    
}
