package object;

public class Vase {
	String Smooth = "Smooth";
	String Cold = "Cold";
	String Round = "Round";
	
	public Vase() {
		Cold = "Very Cold";
		Round = "Very Round";
		Smooth = "Very Smooth";
		
		
	}
	
	
	public static void vaseCreation() {
		
		Vase myVase = new Vase();
		
		System.out.println(myVase.Cold);
		System.out.println(myVase.Round);
		System.out.println(myVase.Smooth);
		
		
	}
	

}
