



#This project is a Maven project. Which means you need maven installed and configured on to your machine in order to run the project
Change directory into the root folder "twitter" of the project
To first run the project, run the command "mvn clean install"
If maven build is successfull, then change directory into sub-directory  "target"
Then run the command :
java -cp twitter-1.0.RELEASE.jar za.co.mini.twitter.TwitterMainAppController ../resources/user.txt ../resources/tweet.txt
In the command above, you are passing the arguments for user.txt and tweet.txt


I used the Mockito framework for unit testing