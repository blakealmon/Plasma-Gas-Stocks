
package AlgorithmForMachineLearning;
import org.opencv.*;
import org.opencv.core.Mat;
import java.util.Random;

public class Algorithm {
String Stock1;
String Stock2;
	
	public Algorithm(){
		
		Stock1 = "PLACEHOLDER1";
		Stock2 = "PLACEHOLDER2";
		
		
	}
	public String processImage(Mat image, String Stock1, String Stock2){
		
		boolean results = false;
		
		
		double leftCounter = 0;
		double rightCounter = 0;
		
		for (int i = 0; i< image.width()/2; i++) {
			
			for(int j = 0; j< image.height(); j++) {
			
				double[] temp = {0,0,0};
				temp = image.get(i, j);
				leftCounter += (temp[0]+temp[1]+temp[2]);
				
			}
		}
		
//		System.out.println("width : " + image.width());
//		System.out.println("channels : " + image.channels());
//		System.out.println("height : " + image.height());
		
		for (int i = image.width()/2; i < image.width(); i++) {
			
			for(int j = 0; j < image.height(); j++) {
			
				double[] temp2 = {0,0,0};
				temp2 = image.get(j, i);
//				System.out.println("Location: "+i + "," + j);
//				System.out.println(temp2[0]);
//				System.out.println(temp2[1]);
//				System.out.println(temp2[2]);
				
				rightCounter += (temp2[0]+temp2[1]+temp2[2]);
				
			}
		}
		
		System.out.println("Left Stock: " + leftCounter);
		System.out.println("Right Stock: " + rightCounter);
		
		
		    
		
		
		
		
		if (leftCounter > rightCounter) {
			return Stock1;
		}
				
		return Stock2;
		
		
	}
	
}