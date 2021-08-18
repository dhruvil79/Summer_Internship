package Logic_Of_Code;

public class Student {
	private int index;
	private long Stu_ID;
	private String Stu_Name;
	private double Stu_CPI;
	
	Student(int index,long Stu_ID,String Stu_Name,double Stu_CPI)
	{
		this.index=index;
		this.Stu_ID=Stu_ID;
		this.Stu_Name=Stu_Name;
		this.Stu_CPI=Stu_CPI;
	}
	
	public int getIndex() {return this.index;}
	public long getId(){return this.Stu_ID;}
	public String getName(){return this.Stu_Name;}
	public double getCpi(){return this.Stu_CPI;}
	
}
