package cs112project1;


public class DataPoint {
	//class variables should be private generally
	private Double f1;
	private Double f2;
	private String label;
	private Boolean isTest;
	
	//constructor
	public DataPoint(Double f1, Double f2, String label, Boolean isTest) {
		this.f1 = f1;
		this.f2 = f2;
		this.label = label;
		this.isTest =isTest;
		
	}
	//no argument constructor
	public DataPoint() {
		this.f1 = null;
		this.f2 = null;
		this.label = null;
		this.isTest = false;	
	}
	//accessors
	public Double getF1() {
		return f1;
	}
	public Double getF2() {
		return f2;
	}
	public String getLabel() {
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
	public void setLabel(Sting label) {
		this.label = label;
		
	}
	public void setIsTest(Boolean isTest) {
		this.isTest = isTest;
	}
	

}











