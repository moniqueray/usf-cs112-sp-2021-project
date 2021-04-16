package project2cs112;

import java.awt.*;  
import java.util.ArrayList; 
import java.util.InputMismatchException;
import javax.swing.*;
import java.util.Scanner;
import java.text.DecimalFormat;    

public class Driver {
	public static void main(String[] args) {
		System.out.println("Enter a number for the value of K:  ");
		Scanner userinput = new Scanner(System.in);
		int k = 0;
		boolean run = true;
		try {
			k = userinput.nextInt();
		}catch (InputMismatchException e) {
			System.out.println("Error");
			run = false;
		}
		if (run) {
			if (k%2 ==0) {
				System.out.print("Error");		
		}else {
			JFrame myFrame = new JFrame();
			myFrame.setTitle("Data Points");
			myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			Container contentPane = myFrame.getContentPane();
			KNNPredictor obj = new KNNPredictor(3, 0, 0);

			ArrayList <DataPoint> data = obj.readData("titanic.csv");

			DecimalFormat decFormat = new DecimalFormat("#%");
			System.out.println("Accuracy:" + (decFormat.format(obj.getAccuracy(data))));
			System.out.println("Precision:" + (decFormat.format(obj.getPrecision(data))));
			JLabel accuracy = new JLabel("Accuracy: " + (decFormat.format(obj.getAccuracy(data))));
			contentPane.add(accuracy);
			JLabel precision = new JLabel("Precision: " + (decFormat.format(obj.getPrecision(data))));
			contentPane.add(precision);

			myFrame.setVisible(true);
			myFrame.setLayout(new GridLayout(2,2));
			myFrame.setSize(200,200);
			
		}
		}	
		userinput.close();

	}
}

