package Alpaca;
import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.net.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
public class API {

    public void callApi(String[] args) throws IOException {

         
    	//URL url = new URL("https://www.google.com");
//        
//        Scanner sc = new Scanner(url.openStream());
//        StringBuffer sb = new StringBuffer();
//        while(sc.hasNext()) {
//            sb.append(sc.next());
//        }
//
//        String result = sb.toString();
//        System.out.println(result);
//        result = result.replaceAll("<[^>]*>", "");
//        System.out.println("Contents of the web page:\n" +result);

    	URL urlObj = new URL("https://www.google.com");
    	HttpURLConnection connection = (HttpURLConnection) urlObj.openConnection();
 //   	connection.setRequestMethod(method.toUpperCase());
 //  	connection.setRequestProperty("Authorization", "BASIC "+new String(encodedBase64));
    	connection.setRequestProperty("Content-Type", "application/json");
    	connection.setRequestProperty("Accept", "application/json");
    	connection.setRequestProperty("Accept-Charset", "UTF-8");
    	connection.setDoInput(true);
    	connection.setUseCaches(false);
    	connection.connect();
    	
    	
	
        
    }
    
    
    
    public boolean outputPostions() {
    	
    	
    	
    	
    	return false;
    }
    
    public static boolean test2() {
        try {
            // Generate absolute URL
            // Base URL = www.gnu.org
            URL url1 = new URL("http://www.gnu.org");
            System.out.println("URL1: " + url1.toString());
 
            // Generate URL for pages with a common base
            URL url2 = new URL(url1, "licenses/gpl.txt");
            System.out.println("URL2: " + url2.toString());
 
            // Generate URLs from different pieces of data
            URL url3 = new URL("http", "www.gnu.org", "/licenses/gpl.txt");
            System.out.println("URL3: " + url3.toString()); 
             
            URL url4 = new URL("http", "www.gnu.org", 80, "/licenses/gpl.txt");
            System.out.println("URL4: " + url4.toString() + "\n");
 
            // Open URL stream as an input stream and print contents to command line
            try (BufferedReader in = new BufferedReader(new InputStreamReader(url4.openStream()))) {
                String inputLine;
 
                // Read the "gpl.txt" text file from its URL representation
                System.out.println("/***** File content (URL4) *****/n");
                while((inputLine = in.readLine()) != null) {
                    System.out.println(inputLine);
                }
            } catch (IOException ioe) {
                ioe.printStackTrace(System.err);
            }
        } catch (MalformedURLException mue) {
            mue.printStackTrace(System.err);
        }
        
        return true;
    }
    
    //public void test3(String urlStr, String jsonBodyStr) throws IOException {
      public void alpacaCommand(String command, String param1, String param2, String param3) throws IOException 
      {
    	 
    	  
    	  String endpoint = "";
    	  
    	  if(command == "PlaceOrder") {endpoint = "orders";
    	   
    	  
    	  URL url = new URL("https://paper-api.alpaca.markets/v2/" + endpoint);
    	  System.out.println(url);
    	
    	  //  URL url = new URL("https://www.google.com");
    	  HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
    	  httpURLConnection.setDoOutput(true);
    	  httpURLConnection.setRequestMethod("POST");
    	  httpURLConnection.setRequestProperty("Content-Type", "application/json");
    	  
    	  httpURLConnection.setRequestProperty("APCA-API-KEY-ID", "PK1S2E1TEW8KCH46AUKV");
    	  httpURLConnection.setRequestProperty("APCA-API-SECRET-KEY", "zENMuEt0i7VwpUr0soNiEQ9eFlajbV3xI3QDoTxf");
    	  
    	 String jsonBodyStr = "{\"symbol\":\"TWTR\", \"qty\":\"2\", \"side\":\"buy\",\"type\":\"market\", \"time_in_force\":\"gtc\"}";
    	 System.out.println(jsonBodyStr); 
   	  
    	  try (OutputStream outputStream = httpURLConnection.getOutputStream()) { 
    	   outputStream.write(jsonBodyStr.getBytes());
    	   outputStream.flush();
    	  }
    	  if (httpURLConnection.getResponseCode() == HttpURLConnection.HTTP_OK) {
    	    try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()))) {
    	      String line;
    	      while ((line = bufferedReader.readLine()) != null) {
    	    	  System.out.println(line);
    	      }
    	    }
    	  } else {
    		 int result = httpURLConnection.getResponseCode();
    		  
    	    System.out.println(result);
    	  }
    	}
      
    	  
    	  
    	  if(command == "GetPositions") {
    		
    		  endpoint = "positions";
    	  
    	  URL url = new URL("https://paper-api.alpaca.markets/v2/" + endpoint);
    	//  URL url = new URL("https://www.google.com");
    	  HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
    	  httpURLConnection.setDoOutput(true);
    	  httpURLConnection.setRequestMethod("GET");
    	  httpURLConnection.setRequestProperty("Content-Type", "application/json");
    	  
    	  httpURLConnection.setRequestProperty("APCA-API-KEY-ID", "PK1S2E1TEW8KCH46AUKV");
    	  httpURLConnection.setRequestProperty("APCA-API-SECRET-KEY", "zENMuEt0i7VwpUr0soNiEQ9eFlajbV3xI3QDoTxf");
    	  
    	  
    	  //try (OutputStream outputStream = httpURLConnection.getOutputStream()) { 
    	  // outputStream.write(jsonBodyStr.getBytes());
    	  // outputStream.flush();
    	  //}
    	  if (httpURLConnection.getResponseCode() == HttpURLConnection.HTTP_OK) {
    	    try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()))) {
    	      String line;
    	      while ((line = bufferedReader.readLine()) != null) {
    	    	  System.out.println(line);
    	      }
    	    }
    	  } else {
    		 int result = httpURLConnection.getResponseCode();
    		  
    	    System.out.println(result);
    	  }
    	}
      }  

}
      