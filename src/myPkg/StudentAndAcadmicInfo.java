package myPkg;

public class StudentAndAcadmicInfo {
	/*****
	 * 
	 * Task for Jayatai
	 * 1. apply check for gender[M,F,O] : Status - NS. req is to make sure value is always set in capital cases --DONE
	 * 2. Take input for marks, marks cant be -ve. Status - NS == DONE
	 * 3. Add rollnumber -- DONE
	 */
	
	//Always try to keep members as private as we dont want to expose to other users
	private String firstName;
	private String lastName;
	private byte age;//as age can be of range 100
	private char gender;
	private float marks[] = new float[5];
	private int rollNumber;
	private char grade;
	private float percentage;
	private String division;
	private String status;
	
	StudentAndAcadmicInfo()
	{
		System.out.println("StudentAndAcadmicInfo::StudentAndAcadmicInfo Creating Student object!");
	}
	
	protected void finalize()  
	{
		System.out.println("StudentAndAcadmicInfo::finalize Destroying Student object!");

	}
	
	/*
	 * Getters and setters of variables
	 */
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public byte getAge() {
		return age;
	}
	public void setAge(byte age) {
		// age range should be between >3 to <100.
		if( age <3  || age >100 )
		{
			System.out.println("\n Invalid Age, setting to default value of 0");
			this.age = 0;
		}	
		else
		{	
			this.age = age;
		}	
	}
	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		if(gender == 'M' || gender == 'm' || gender == 'F' || gender == 'f' || gender == 'O' || gender == 'o' ) {
			 char gender1 = Character.toUpperCase(gender);
				this.gender = gender1;
		}
		else {
			System.out.println(" StudentAndAcadmicInfo :: setGender :: Invalid gender input.Setting by default 'Undefine'.");
			this.gender ='U';

		}
		
	}
	
	public void setMarks(float[] marks) {
		for( int i =0; i<5; i++) {
			if( marks[i]>=0 && marks[i] <=100) {
				this.marks[i] = marks[i];
				
			}
			else {
				System.out.println("StudentAndAcadmicInfo :: setMarks :: Marks cannot be greater than 100 and less than 0.Set default to 0");
			   this.marks[i] =0;
			}
		}
		for(int i=0; i<5;i++) {
			percentage= percentage+ this.marks[i];
		}
		// calculation of percentage : (sum of marks/ sum of max mark each)* 100
		//reason to add percentage is : in case ever grade, division and status called before matks  , then how the percentage will be callculated
		// that s they reason of calculating percentage within setMark().
				percentage = (percentage/500)*100;
	}
	
	// checking grade by getting list of marks
	public char getGrade() {
		//System.out.println("percentage is : "+ percentage);
		if( percentage>90) {
			grade ='A';
		}
		else if(percentage>70 && percentage <=90) {
			grade ='B';
		}
		else if ( percentage>50 && percentage <=70) {
			grade ='C';
		}
		else if( percentage>33.3 && percentage<=50) {
			grade ='D';
		}
		else  {
			grade ='F';
		}
		return grade;
	}
	
	// division calculation
	 public String getDivision() {
		 if(percentage >60) {
			 division ="First";
		 }
		 else if( percentage >=33.3 && percentage <=60) {
			 division ="Second";
		 }
		 // if percentage is less than 33.3 %, setting default value of division is NA with error msg
		 else {
			  System.out.println("StudentAndAcadmicInfo:: getDivision:: Not Applicable.Default value to NA");
			  division= "NA";
		 }
		return division;
	 }
	 
	 // Status : Pass/Fail
	 public String getStatus() {
		 if( percentage >=33.3 && percentage<=100) {
			 status= "Pass";
		 }
		 else {
			 status ="Fail";
		 }
		 return status;
	 }
	public String getFullName()
	{
		if( firstName.isEmpty() && lastName.isEmpty() )
		{
			return "No Name was inserted";
		}	
		return lastName + "," + firstName; 
	}

	public int getRollNumber() {
		return rollNumber;
	}

	public void setRollNumber(int rollNumber) {
		if(rollNumber <=0) {
			System.out.println(" StudentAndAcadmicInfo:: setRollNumber:: Roll number cannot be negative and 0. Default set it to 1");
		   this.rollNumber = 1;
		}
		else {
			this.rollNumber = rollNumber;
		}
	}
	
}
