package za.co.mini.twitter;


import static org.mockito.Mockito.*;

import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.internal.matchers.Any;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;

import za.co.twitter.entity.Tweet;
import za.co.twitter.entity.User;
import za.co.twitter.repository.UserRepository;
/**
*
* @author Arthur Gwatidzo
*/
@RunWith(MockitoJUnitRunner.class)
public class CounterfeitTweetsControllerTest {
	
	@Mock
	UserRepository userRepository;
	
	
	@Mock 
	Map<String,User> users;
	
	
	@InjectMocks
	CounterfeitTweetsController counterfeitTweetsController;
	

	@Before
	public void setup() throws Exception{
		
	}
	
	@Ignore
	@Test
	public void testFireTweets() {
		when(userRepository.getUsers()).then((Answer<?>) buildUsers());
		//when(users.containsKey(Matchers.anyString())).thenReturn("fake Tweet");
		
		try {
			verify(counterfeitTweetsController,times(1)).fireTweets();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
	public Map<String,User> buildUsers() {
		 Map<String,User> users = new TreeMap<>();
		 
		 User user = new User();
		 user.addFollower("Arthur");
		 user.addTweet(buildTweet());
		 users.put("Test", user);
		 
		 return users;
	}
	
	
	
	public Tweet buildTweet() {
		return new Tweet("Today is a good day", "Arthur");
	}
}
