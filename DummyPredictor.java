package cs112project1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import cs112project1.DataPoint;

public class DummyPredictor extends Predictor {

	
	public ArrayList<DataPoint> readData(String filename) {
		ArrayList<DataPoint> data = new ArrayList<DataPoint>(2);
		try {
			Scanner sc = new Scanner(new File("Project1.txt"));
				while(sc.hasNextLine()) {
					double f1 = sc.nextDouble();
					double f2 = sc.nextDouble();
					String label = sc.next();
					boolean isTest = sc.nextBoolean();
					DataPoint obj = new DataPoint(f1,f2,label,isTest);
					data.add(obj);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
       return data;		
	}

	public String test(DataPoint data) {
		return data.getLabel();
		
	}

	Double getAccuracy(ArrayList<DataPoint> data) {
		return 1.0;
	}

	Double getPrecision(ArrayList<DataPoint> data) {
		return 2.0;
	}
	


}




































