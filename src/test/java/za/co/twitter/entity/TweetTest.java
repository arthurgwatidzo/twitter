package za.co.twitter.entity;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class TweetTest {
	
	@Test
	public void getUserName() {
		Tweet tweet = new Tweet("Arthur", "Good morning");
		assertEquals(tweet.getUserName(),"Arthur");
	}
	
	
	@Test
	public void getText() {
		Tweet tweet = new Tweet("Arthur", "Good morning");
		assertEquals(tweet.getText(),"Good morning");
	}


}
