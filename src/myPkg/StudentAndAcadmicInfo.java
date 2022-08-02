package myPkg;

public class StudentAndAcadmicInfo {
	/*****
	 * 
	 * Task for Jayatai
	 * 1. apply check for gender[M,F,O] : Status - NS. req is to make sure value is always set in capital cases
	 * 2. Take input for marks, marks cant be -ve. Status - NS
	 * 3. Add rollnumber
	 */
	
	//Always try to keep members as private as we dont want to expose to other users
	private String firstName;
	private String lastName;
	private byte age;//as age can be of range 100
	private char gender;
	private float marks[] = new float[5];
	StudentAndAcadmicInfo()
	{
		System.out.println("StudentAndAcadmicInfo::StudentAndAcadmicInfo Creating Student object!");
	}
	
	protected void finalize()  
	{
		System.out.println("StudentAndAcadmicInfo::finalize Destroying Student object!");

	}
	
	
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
		if( age < 3 )
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
		this.gender = gender;
	}
	public float[] getMarks() {
		return marks;
	}
	public void setMarks(float[] marks) {
		this.marks = marks;
	}
	public String getFullName()
	{
		if( firstName.isEmpty() && lastName.isEmpty() )
		{
			return "No Name was inserted";
		}	
		return lastName + "," + firstName; 
	}
	
}
