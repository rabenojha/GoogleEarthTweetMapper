package eot_Rabin_Sushmita_Maciej;


import java.io.IOException;
import java.io.File;
import java.io.FileWriter;


public class ImagetoKML {
	

	public static String image_to_kml(String working_directory) {  // returns string
		String output = "";
		
		// Creating an array for the KML (only body)
		
		String [] Array = {
				"<Folder>",
				"<name>Boston</name>\\r\\n",
				"",
				" <GroundOverlay>\\r\\n",
				"<name>WMS Image</name>\\r\\n",
				"<description>The image is downloaded \\r\\n"
				+ "          from http://maps.heigit.org/osm-wms/service </description>\\r\\n",
				"<Icon>\\r\\n"
				+ "        <href> working directory + \"\\wms_img.png\"</href>\\r\\n"
				+ "      </Icon>\\r\\n",
				"<LatLonBox>\\r\\n",
				"<north>42.42</north>\\r\\n",
				"<south>42.32</south>\\r\\n",
				"<east>-71.03</east>\\r\\n",
				"<west>-71.13</west>\\r\\n",
				"<rotation>0</rotation>\\r\\n",
				"</LatLonBox>\\r\\n",
				"</GroundOverlay>\\r\\n",
				"</Folder>",
						

									
				
		
	};
		System.out.println("-------------------------------------------------");
//		System.out.println("Works fine until here");
		
		
		
		
		// storing the information to the string

			
		for (String i :Array) {
			output = output+i;
		}

	
		return output;
}
}
