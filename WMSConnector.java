package eot_Rabin_Sushmita_Maciej;


import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Path;

import javax.imageio.ImageIO;

import org.apache.commons.io.IOUtils;
import org.geotools.ows.ServiceException;
import org.geotools.ows.wms.WebMapServer;
import org.geotools.ows.wms.request.GetMapRequest;
import org.geotools.ows.wms.response.GetMapResponse;

public class WMSConnector {
	
  public static void get_wms_image(String url, String working_directory) {

	
    URL wms_url = null;
    try {
      wms_url = new URL(url);
      System.out.println("No issue with the URL");
      System.out.println("-----------------------------");
    } catch (MalformedURLException e) {
      // will not happen
    }

    
    // Creating WMS object
    WebMapServer wms = null;
    try {
      wms = new WebMapServer(wms_url);
      GetMapRequest request = wms.createGetMapRequest();
      
      
      // requesting the layer from the WMS server
      request.addLayer("osm_auto:all", "");
      
      
      // setting the object properties
      String format = "image/png";
      request.setFormat(format);
      request.setDimensions("1000", "1000"); // sets the dimensions of the image
                                           // to be returned from the server
      request.setTransparent(true);
      request.setSRS("EPSG:4326");
      request.setBBox("42.32,-71.13,42.42,-71.03");
      
      

      try {
        GetMapResponse response = wms.issueRequest(request);
        
        if (response.getContentType().equalsIgnoreCase(format)) {
          BufferedImage image = ImageIO.read(response.getInputStream());
          File outputfile = new File(working_directory + "\\wms_img.png"); //file is created at this path
//          File outputfile = new File(image_directory);
          ImageIO.write(image, "png", outputfile);
          System.out.println("No errors in communicating with the server.");
          System.out.println("-------------------------------------------------");
          System.out.println("The image has been written to your working directory.");
        
        } else {
          StringWriter writer = new StringWriter();
          IOUtils.copy(response.getInputStream(), writer);
          String error = writer.toString();
          System.out.println(error);

        }
      } catch (ServiceException | IOException e) {
        e.printStackTrace();

      }
      
    } catch (IOException e) {
    	System.out.println ("Server returned a Input/Output error");
    
    } catch (ServiceException e) {
      System.out.println ("Server returned a ServiceException error");
    }

  }
}
