package com.opencvcamera;

//imports from other packages


//import Alpaca.API;
//import AlgorithmForMachineLearning.Algorithm;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfByte;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.videoio.VideoCapture; 
import org.opencv.core.*;
import org.opencv.*;

public class Camera extends JFrame{

	
	//camera screen
	private JLabel cameraScreen;
	
	private JButton btnCapture;
	
	private VideoCapture capture;
	private Mat image;

	private boolean clicked = false;
	private boolean flag = false;
	private boolean flag2 = false;
	
	public Camera(){
		
		
		//design ui
		setLayout(null);
		cameraScreen = new JLabel();
		cameraScreen.setBounds(0, 0, 640, 480);
		add(cameraScreen);
		
		btnCapture = new JButton("Picture");
		btnCapture.setBounds(300, 480, 80, 40);
		add(btnCapture);
		
		btnCapture.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				clicked = true;
			}
			
			
			
		});
		
		
		setSize(new Dimension(640,560));
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
	}
	
	//create camera
	public void startCamera() {
		capture = new VideoCapture(0);
		

		
		image = new Mat();

		byte[] imageData;
		
		
		ImageIcon icon;
		
		// Creates a new Alpaca object
		   Alpaca.API myApi = new Alpaca.API();
		   AlgorithmForMachineLearning.Algorithm myAlgorithm = new AlgorithmForMachineLearning.Algorithm();
		   
		// Processing loop
		while(true) {
			//read image to matrix
			capture.read(image);
			
//			System.out.println("width : " + image.width());
//			System.out.println("channels : " + image.channels());
//			System.out.println("height : " + image.height());
//
//			
			
//			
//			
//			System.out.println("R : " + temp[2]);
//			System.out.println("B : " + temp[0]);
//			System.out.println("G : " + temp[1]);
			
			
			
			//convert matrix to byte
			final MatOfByte buf  = new MatOfByte();
			Imgcodecs.imencode(".jpg", image, buf);
		//	System.out.println(buf);
			imageData = buf.toArray();
			//add to JLabel
			icon = new ImageIcon(imageData);
			cameraScreen.setIcon(icon);
			
			
			
			
			
			
//			//capture and save to file
//			
//				if(clicked) {
//				//prompt for enter image name
//				String name = JOptionPane.showInputDialog(this,"Enter image name" );
//				if(name == null) {
//					name = new SimpleDateFormat("yyyy-mm-dd-hh-mm-ss").format(new Date());
//					
//				}
//				//write to file
//				Imgcodecs.imwrite("images/" + name + ".jpg", image);
//			
//				clicked = false;
//			}
		
			 
			
			/// Main code to process the data
			
			
		
			//DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss:SSS");  
			 DateTimeFormatter dtf = DateTimeFormatter.ofPattern("SSS");  
			 LocalDateTime now = LocalDateTime.now();  
			// System.out.println(dtf.format(now));  
			 
			 
			 int timer = (Integer.parseInt(dtf.format(now))%5);
			 //System.out.println(timer);  
			 
			  
			  if((timer == 0)   && (flag == false)){
				   flag = true;
				  
						   
			   }
					   
			   
			  
			  // Check to see if the timer is zero 
			  // also to make sure this is only called once
			   if ((flag == true) && (flag2 == false)) {
				   
				   
				   String theStock = myAlgorithm.processImage(image, "AAPL","TSLA");
		//		   boolean result2 = true;
				   
				   System.out.println(theStock);
				   
				   if(true) {
					// Executing the trade here   
					  //a System.out.println("1 trade");
					   
					   
					   
					   // API Call uses try/catch block to catch any exceptions
					   // instead of crashing the program
					   
					   
					   
					   //sleep
					   try {
							TimeUnit.SECONDS.sleep(1);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					   
					   
					   try { 
						   
						   
						   
						   
						   Alpaca.API myAlpaca = new Alpaca.API();
						   //myAlpaca.test3("https://www.google.com","{:}");
						   //myApi.alpacaCommand("GetPositions", "", "", "");
						   myApi.alpacaCommand("PlaceOrder", "", "", "");
						   
						 //  myApi.alpacaCommand("Buy", "100", "TSLA", "");
						   
						   System.out.println();
						   
						  
						   
					   
					   } 
					   
					   catch (IOException e) {
						   		// TODO Auto-generated catch block
						   		e.printStackTrace();
					   			}
					   
				   }
				   
				   
				   		
				   // Reset flag after trading to make sure the program
				   // knows that the trade has been executed
				   flag2 = true;
				 	   
			   }
			   
			   // Resets the flags once the timer hits 1
			   if(timer != 0) {
				   
				   flag = false;
				   flag2 = false;
			   }			   
			  
		}
	}
	
	
	// Main starts the camera and runs the processing loop
	public static void main(String[] args) {
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				Camera camera = new Camera();
				//start camera in thread
				new Thread(new Runnable() {
					
					@Override
					public void run() {
						// Begin camera processing loop
					  camera.startCamera();
					}
					
					
				}).start();
			}
			
		
		});
				
	}

}