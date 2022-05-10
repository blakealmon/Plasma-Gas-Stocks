package Alpaca;
import java.io.IOException;
import java.net.URL;
import java.util.Scanner;


public class API {

    public void callApi(String[] args) throws IOException {


        URL url = new URL("https://www.google.com");
        Scanner sc = new Scanner(url.openStream());
        StringBuffer sb = new StringBuffer();
        while(sc.hasNext()) {
            sb.append(sc.next());
        }

        String result = sb.toString();
        System.out.println(result);
        result = result.replaceAll("<[^>]*>", "");
        System.out.println("Contents of the web page:\n" +result);


    }
}