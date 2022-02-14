package eot_Rabin_Sushmita_Maciej;


import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays;
import java.util.Date;

public class TweetToKML {
	
	
	public static void to_KML (String working_directory) {
		String kmlbody = ""; 													//Defining empty string
		
		String kml_header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n"
				+ "<kml xmlns=\"http://www.opengis.net/kml/2.2\">\r\n"
				+ " <Document>\r\n";
		
		String kml_footer = " </Document>\r\n"
				+ "</kml> \r\n";

		// create array named "csvtokml"
		
		ArrayList<String> csvtokml = new ArrayList<String>(); 
		int count = 0;
		
		try {
			FileReader fileReader = new FileReader (working_directory + "\\tweet.csv"); // read CSV file from local directory
			BufferedReader Reader = new BufferedReader(fileReader);
			Scanner s = new Scanner (Reader);
			Reader.readLine();
			
			// define strings and arrays to be used below
			
			String line1=null;
			String [] dateandtime = null;
			String top = null;
			String left = null;
			String right = null;
			String bottom = null;
			String colours = null;
			
			
			while (s.hasNextLine() ) {
				
				
				String line = s.nextLine();

				String[] data = line.split(";");

				dateandtime = data[6].split(" ");       

				
                //coordinates for extruded polygon
				
				Double top_longitude = (Double.valueOf(data[1]));
				Double top_latitude = (Double.valueOf(data[2]) + 0.0050);
				Double left_longitude = (Double.valueOf(data[1]) + 0.0025);
				Double left_latitude = (Double.valueOf(data[2]) - 0.0025);
				Double right_longitude = (Double.valueOf(data[1]) - 0.0025);
				Double right_latitude = (Double.valueOf(data[2]) + 0.0025);
				
				
				// combine latitude and longitude from above calculation
				
				top = top_longitude + "," + top_latitude ;
				left = left_longitude + "," + left_latitude ;
				right = right_longitude + "," + right_latitude ;
				bottom = data[1] + "," + data[2];
				
//				System.out.println(bottom);
				
                // Date
                String date = dateandtime[0];
                
              
                
                // Time 
              String time = dateandtime[1];

              // Hashtags 
              
              String hashtag = data[3];
             if (hashtag != null) {
             	colours = "FFFF0000";       //blue // be careful with the color codes used here. KML uses an 8 digit HEX color format rather than traditional HEX format. 
             }
             if (hashtag == "") {
             	colours = "FFFF00FF";       //pink // be careful with the color codes used here. KML uses an 8 digit HEX color format rather than traditional HEX format. 
             } 
                
                
                csvtokml.add(  "<name>Tweets.kml</name>\r\n"
        				+ "  <open>0</open>\r\n"
        				+ "  <Style id=\"style1\">\r\n"
        				+"<LineStyle>\r\n"
        				+ "      <color>" + colours + "</color>\r\n"
        				+ "      <width>3</width>\r\n"
        				+ "    </LineStyle>\r\n"
        				+ "    <PolyStyle>\r\n"
        				+ "        <color>"+colours+"</color>\r\n"
        				+ "        <colorMode>random</colorMode>\r\n"
        				+ "    </PolyStyle>\r\n"
        				+ "  </Style>\r\n" 
                		+ "  <Placemark>\r\n"
        				+ "<styleUrl>#style1</styleUrl>\r\n"
						+ "<description>\r\n"   // this information will be displayed on clicking the feature
						+ "        <![CDATA[\r\n"
						+ "          <h2>Tweet Details</h2>\r\n"
						+ "<p><b><i>Tweet Date</i></b> : " +dateandtime[0]+ "</p>"
						+ "<p><b><i>Tweet Time</i></b> : " +dateandtime[1]+ "</p>"
						+ "<p><b><i>Tweet</i></b> : " +data[5]+ "</p>"
						+ "<p><b><i>Hashtags</i></b> : " +hashtag+ "</p>"
						+ "        ]]>\r\n"
						+ "      </description>"
    					+ "    <TimeStamp> \r\n"
    					+ "		 <when>" + dateandtime[0]+ "T" + dateandtime[1]+ ":00</when>\r\n "
    					+ "	   </TimeStamp> \r\n"
    					+ "    <Polygon>\r\n"
    					+ "      <extrude>1</extrude>\r\n"
    					+ "      <altitudeMode>relativeToGround</altitudeMode>\r\n"
    					+ "      <outerBoundaryIs>\r\n"
    					+ "        <LinearRing>\r\n"
    					+ "          <coordinates>\r\n"
    					+ top + ",800\n"
    					+ left + ",800\n"       // the third element here controls the height of extruded feature
    					+ bottom + ",800\n"		// in this case the altitude is 880 meter
    					+ right + ",800\n"
    					+ top + ",800\n"
    					+ "          </coordinates>\r\n"
    					+ "        </LinearRing>\r\n"
    					+ "      </outerBoundaryIs>\r\n"
    					+ "    </Polygon>\r\n"
    					+ "  </Placemark>\r\n"
		
    			
    		);  // complete the addition of content to csvtokml array
                
				
			} // End of while
			System.out.println("KML structure is created. ");
			System.out.println("------------------------");
			
			
			
			count++;
			Reader.close(); // close the reader
			s.close(); //close the scanner
			
			}catch(IOException e) {
			e.printStackTrace();
		}
//		System.out.println("lines completed");
		
		for (int i = 1; i< csvtokml.size(); i++) {
			kmlbody = String.join(",", csvtokml);
		}
		try {
			FileWriter filewriter = new FileWriter (working_directory+"\\tweet.kml");
			filewriter.write(kml_header+kmlbody+kml_footer);
			filewriter.close();
			System.out.println("KML structure is written to the file in local drive.");
			System.out.println("----------------------------------------------------");
		}catch (IOException ex){
			ex.printStackTrace();
		}

	
		
	} // end main method
	
	 


	} // end main class

   

