package eot_Rabin_Sushmita_Maciej;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;


public class TweetDownload {
	
	
	public static void download(String tweet_link,String working_directory ) throws Exception{
		String filepath = working_directory + "\\tweet.csv";
		File file = new File(filepath);
	    URL url = new URL(tweet_link);
	    FileUtils.copyURLToFile(url, file);
	    System.out.println("-------------------------------------------------");
	    System.out.println("The CSV file containing the tweets is downloaded to your local directory");
	    System.out.println("-------------------------------------------------");
	 }

}
