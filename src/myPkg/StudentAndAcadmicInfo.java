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
				this.marks = marks;
			}
		else {
			System.out.println("StudentAndAcadmicInfo :: setMarks :: Marks cannot be greater than 100 and less than 0.");
		}
		}
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
