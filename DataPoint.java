package project2cs112;

public class DataPoint {
	//class variables should be private generally
		private Double f1;
		private Double f2;
		private int label;
		private Boolean isTest;
		
		//constructor
		public DataPoint(double v, double label2, int d, boolean e) {
			this.f1 = v;
			this.f2 = label2;
			this.label = d;
			this.isTest =e;
			
		}
		//no argument constructor
		public DataPoint() {
			this.f1 = null;
			this.f2 = null;
			this.label = 0;
			this.isTest = false;	
		}
		//access
		public Double getF1() {
			return f1;
		}
		public Double getF2() {
			return f2;
		}
		public int getLabel() {
			return label;
		}
		public Boolean getIsTest() {
			return isTest;
		}
		
		public void setF1(Double f1) {
			if(f1<0) {
				return;
			}
			this.f1 = f1;
		}
		public void setF2(Double f2) {
			if(f2<0) {
				return;
			}
			this.f2 = f2;
		}
		public void setLabel(int label) {
			this.label = label;
			
		}
		public void setIsTest(Boolean isTest) {
			this.isTest = isTest;
		}
		

	}











