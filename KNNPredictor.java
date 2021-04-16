package project2cs112;

 
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

public class KNNPredictor extends Predictor {
	private int K = 3;
	private int Survived = 0;
	private int notSurvived=0;
	private ArrayList<DataPoint> dataSet = new ArrayList<DataPoint>(); 
	public KNNPredictor(int kParam) {
		this.K = kParam;
		this.Survived = 0;
		this.notSurvived = 0;
	}
	public KNNPredictor(int i, int j, int m) {
	}
	private List<String> getRecordFromLine(String line) {
		List<String> values = new ArrayList<String>();
		try (Scanner rowScanner = new Scanner(line)) {
			rowScanner.useDelimiter(",");
			while (rowScanner.hasNext()) {
				values.add(rowScanner.next());
			}
		}
		return values;
	}
	public boolean myRandomBoolean() {
		boolean randomVariable;
		Random rand = new Random();
		double randNum = rand.nextDouble();
		// 90% of the data is reserved for training
		if (randNum < 0.9) {
			randomVariable = true;
			// Set the type of DataPoint as “train” and put into the Collection
		} else {
			randomVariable = false;
			// Set the type of DataPoint as “test” and put into theCollection}
		}
		return randomVariable;
	}
	public ArrayList<DataPoint> readData(String filename) {
		ArrayList<DataPoint> myArrayList = new ArrayList<DataPoint>(); 
		int numCounter = 0;
		try {
			Scanner scanner = new Scanner(new File(filename));
			scanner.nextLine();
			while (scanner.hasNextLine()) {
				List<String> records = getRecordFromLine(scanner.nextLine());
				if (records.size() < 7) {
					continue;
				}
				numCounter+=1;
				String f1 = records.get(5);
				String f2 = records.get(6);
				String label = records.get(1);
				double w1;
				double w2;
				int wlabel;
				
				try {
					w1 = Double.parseDouble(f1);
					w2 = Double.parseDouble(f2);
					wlabel = Integer.parseInt(label);
				} catch (NumberFormatException e) {
					continue;
				}
				
			
				boolean w = myRandomBoolean();
				if (w == true) {
					if (wlabel == 0) {
						notSurvived +=1;
					}
					else {
						Survived+=1;
					}
				}
				DataPoint myDatapoint = new DataPoint(w1,w2,wlabel,w);
				myArrayList.add(myDatapoint);
			}
			
			
		}

		catch (FileNotFoundException ex) {
		ex.printStackTrace();
	}
		System.out.println("Number of Survived: " + Survived);
		System.out.println("Number of Training DataPoint:" + notSurvived);
		return myArrayList;
}
	//get distance
	 private double getDistance(DataPoint p1, DataPoint p2) {
		 double x1 = p1.getF1();
		 double x2 = p2.getF1();
		 double y2 =p2.getF2();
		 double y1 = p1.getF2();
		 return Math.sqrt((y2 - y1) * (y2-y1) + (x2-x1) * (x2-x1));
	 }
	 
	 //string test
	 public String test(DataPoint data) {
		 Double[][] Array2D = new Double[Survived + notSurvived][2];
		 int survived = 0;
		 int notSurvived2 = 0;
		 
		 double label = 0;
			for(int i = 0; i<(Survived + notSurvived); i++) {
				 DataPoint myData = dataSet.get(i);
				 double distance = getDistance(data,myData);
				 
				 //double distance = getDistance(data, dataSet.get(i));
				 label = myData.getLabel();
				 Array2D[i][0] = distance;
				 
				 Array2D[i][1] = label;
			 }
			 
			 java.util.Arrays.sort(Array2D, new java.util.Comparator<Double[]>() {
				 public int compare(Double[] a,Double[] b){
					 return a[0].compareTo(b[0]);	 
				 } 
			
			 });
			 
			 for (int i = 0; i < K; i++) {
				 if (Array2D[i][1] == 1.0) {
					 survived++;
				 } else {
					 notSurvived2++;
				 }
			 }
		 if (survived > notSurvived2) {
			 return "1";
		 }
		return "0";
		 
	 }
	
	 
	 public Double getAccuracy(ArrayList<DataPoint> data) {
		 double truePositive = 0.0;
		 double falsePositive = 0.0;
		 double trueNegative = 0.0;
		 double falseNegative = 0.0;
		 
		 double myDataPointLabels = 0;
		 
		 double prediction;
		 
		 for (DataPoint i : data) {
			 myDataPointLabels = i.getLabel();
			 dataSet = data;
			 prediction = Double.parseDouble(test(i));
			 
			 
			 if (myDataPointLabels == 1.0 && prediction == 1.0) {
				truePositive+= 1.0;
			 }
			 else if (myDataPointLabels == 1.0 && prediction == 0.0) {
				 falsePositive+=1.0;
			 }
			 else if (myDataPointLabels == 0.0 && prediction == 1.0) {
				 falseNegative+=1.0;	 
			 }
			 else if (myDataPointLabels == 0.0 && prediction == 0.0) {
				 trueNegative+=1.0;
			 }
		 }
		 double result = (truePositive+trueNegative) / (truePositive + trueNegative + falsePositive + falseNegative);
		 return (result);
	 }
			 
		
		 
	
	 
	 public Double getPrecision(ArrayList<DataPoint> data) {
		 double truePositive = 0.0;
		 double falsePositive = 0.0;
		 double trueNegative = 0.0;
		 double falseNegative = 0.0;
		 
		 double myDataPointLabels = 0;
		 double prediction;
		 
		 for (DataPoint i : data) {
			 myDataPointLabels = i.getLabel();
			 dataSet = data;
			 prediction = Double.parseDouble(test(i));
			 
			 
			 if (myDataPointLabels == 1.0 && prediction == 1.0) {
				truePositive+= 1.0;
			 }
			 else if (myDataPointLabels == 1.0 && prediction == 0.0) {
				 falsePositive+=1.0;
			 }
			 else if (myDataPointLabels == 0.0 && prediction == 1.0) {
				 falseNegative+=1.0;	 
			 }
			 else if (myDataPointLabels == 0.0 && prediction == 0.0) {
				 trueNegative+=1.0;
			 }
		 }
		 return truePositive / (truePositive + falseNegative);
	 }
}







