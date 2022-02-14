package eot_Rabin_Sushmita_Maciej;


import java.io.IOException;
import java.io.File;
import java.io.FileWriter;


public class ImagetoKML {
	
	public static void image_to_kml(String working_directory) {
		
		// Creating an array for the KML
		
		String [] Array = {"<?xml version=\"1.0\" encoding=\"UTF-8\"?>",
				"<kml xmlns=\"http://www.opengis.net/kml/2.2\">",
				"<Folder>",
				"<name>Boston</name>",
				"",
				" <GroundOverlay>",
				"<name></name>",
				"<description>The image is downloaded \r\n"
				+ "          on July 13th, 2001.</description>",
				"<Icon>\r\n"
				+ "        <href> working directory + \"\\wms_img.png\"</href>\r\n"
				+ "      </Icon>",
				"<LatLonBox>",
				"<north>42.42</north>",
				"<south>42.32</south>",
				"<east>-71.03</east>",
				"<west>-71.13</west>",
				"<rotation>-0.1556640799496235</rotation>",
				"</LatLonBox>",
				"</GroundOverlay>",
				"</Folder>",
				"</kml>"
				
		
	};
		System.out.println("-------------------------------------------------");
//		System.out.println("Works fine until here");
		System.out.println("-----------------------------");
		
		
		
		// storing the file
		
		try {
//			
			// Creates a FileWriter
			
			FileWriter output = new FileWriter(working_directory + "\\img.kml");
			
			for (String i :Array) {
				output.write(i);
			}
			output.close(); // Closing the file writer
			System.out.println("Successfull in converting PNG format to KML structure");
			System.out.println("-------------------------------------------------");
			System.out.println("Successfull in storing the file to local directory");
			
		}catch (IOException e) {
			System.out.println("There was an error in creating and storing the file");
		}
	

}
}