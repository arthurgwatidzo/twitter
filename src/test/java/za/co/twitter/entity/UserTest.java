package za.co.twitter.entity;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import junit.framework.TestCase;

public class UserTest{

	@Test
	public void testGetName() {
		User user = new User();
		user.setName("Tapiwa");
		assertTrue(user.getName()=="Tapiwa");
		
	}

	@Test
	public void testSetName() {
		User user = new User();
		user.setName("Arthur");
		assertTrue(user.getName()=="Arthur");
	}

	@Ignore
	public void testGetFollowers() {
		//fail("Not yet implemented");
	}

	@Ignore
	public void testGetFeedHistory() {
		//fail("Not yet implemented");
	}
	
	
	
	public List<String> buildFollowers(){
		
		List<String> followers = new ArrayList<>();
		followers.add("James");
		followers.add("Smiley");
		
		return followers;
		
	}

}
