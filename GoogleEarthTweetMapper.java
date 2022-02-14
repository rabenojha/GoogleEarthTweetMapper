package eot_Rabin_Sushmita_Maciej;


public class GoogleEarthTweetMapper {
	
	// Setting the working directory. Please remember to change this to your setting before you run the program.
	public static String working_directory = "D:\\CDE\\1st semester\\Practice  Software Development\\End term project\\Outputs";
//	public static String image_directory = "D:\\CDE\\1st semester\\Practice  Software Development\\End term project\\Outputs\\wms_img.png";
//	public static String kml_directory = "D:\\CDE\\1st semester\\Practice  Software Development\\End term project\\Outputs\\img.kml";
//	public static String tweet_directory = "D:\\CDE\\1st semester\\Practice  Software Development\\End term project\\Outputs\\tweet.csv";
	

	
	// WMS information
	
	public static String url = "https://maps.heigit.org/osm-wms/service?service=WMS&request=GetCapabilities&version=1.3.0";
	
	// Twitter URL 
	
	public static String tweet_link = "http://www.berndresch.com/work/twitter.csv";
	
	
	// Main method//
	// We will call all other methods of another classes in this package from here//
	
	public static void main (String[] args) {
		
		WMSConnector.get_wms_image(url,working_directory);
		
		ImagetoKML.image_to_kml(working_directory);
		
		try {
			TweetDownload.download(tweet_link,working_directory);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		TweetToKML.to_KML(working_directory);
		System.out.println("The KML file created in your directory shows tweets in two color of extruded polygons.");
		System.out.println("---------------------------------------------------------------------------------------");
		System.out.println("Blue color for tweets that contains at least one hashtag and Pink color for tweets that doesn't contain hashtag.");
		
		


	} 

} 
