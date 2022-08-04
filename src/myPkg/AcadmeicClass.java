package myPkg;

import java.util.ArrayList;
import java.util.Scanner;

public class AcadmeicClass {
	private ArrayList<StudentAndAcadmicInfo> studentList;
	private String className;
	AcadmeicClass( String className )
	{
		this.className = className;
		//My Logs Format is :: ClassName::FunctionName:: Text/Msg
		System.out.println("AcadmeicClass::AcadmeicClass Initalizing class " + className );
		studentList = new ArrayList<StudentAndAcadmicInfo>();
	}
	protected void finalize()  
	{
		System.out.println("AcadmeicClass::finalize Destroying AcadmeicClass object!");

	}
	private void printDetail( StudentAndAcadmicInfo obj )
	{
		System.out.println("AcadmeicClass::printDetail Student Details Started \n");
		System.out.println("Name: " + obj.getFullName() );
		System.out.println("Age: " + obj.getAge() );
		System.out.println("Gender: " + obj.getGender() );
		System.out.println("Roll number." + obj.getRollNumber());
		System.out.println("Grade." + obj.getGrade());
		System.out.println("Division." + obj.getDivision());
		System.out.println("Status." + obj.getStatus());
		System.out.println("AcadmeicClass::printDetail Student Details Ended \n");

	}
	private void showStudentDetail()
	{
		if(studentList.size()>0){
			for( int i=0 ; i < studentList.size(); i++ )
			{
					printDetail( studentList.get(i) );
			}
		}
		// adding check when arraylist is empty and use wants to view records
		else {
			System.out.println("AcadmeicClass:: showStudentDetail List is empty.No record to show");
		}
	}
	/*
	 * Delete record by rollnumber provided by user.
	 * Asking user to pass rollnumber to remove from storage.
	 *  onece rollnumber is received, start comparing with each objs present  inside  arraylist.
	 */
	private  void deleteRecordByRollnumber() {
  
		System.out.println("AcadmeicClass::deleteRecordByRollnumber entering into method");
		Scanner scan = new Scanner(System.in);
		System.out.println("AcadmeicClass::deleteRecordByRollnumber Enter rollnumber to be delete");
		int rollnumber = scan.nextInt();
		int flag=0;
		for(int i=0; i< studentList.size(); i++) {
			if( rollnumber == studentList.get(i).getRollNumber()){
				studentList.remove(i);
				flag++;
				System.out.println("AcadmeicClass::deleteRecordByRollnumber Delete of record for  " + rollnumber + " is successfull");
				break;
			}				
		}
		if(flag ==0) {
			System.out.println("AcadmeicClass::deleteRecordByRollnumber No record present with this  " + rollnumber);
		}
		System.out.println("AcadmeicClass::deleteRecordByRollnumber existing from delete record");
	}
	
	
	private void searchMenu()
	{
		//TO DO: Update API For menu for all search ops
		System.out.println( this.getClass().toString() + "::searchMenu:: Enter Age " );
		Scanner scan = new Scanner(System.in);
		byte age = scan.nextByte();
		searchStudent( age );
	}
	private void searchStudent(byte age)
	{
		boolean found = false;
		for( int i=0 ; i < studentList.size(); i++ )
		{
			if( studentList.get(i).getAge() == age )
			{
				found = true;
				printDetail( studentList.get(i) );
			}	

		}	
		if( !found )
		{	
			System.out.println(this.getClass().toString() + "::searchStudent:: No student found for age " + age );
		}
	}
	private void addStudentDetail()
	{
		Scanner scan = new Scanner(System.in);
		do
		{
			System.out.println("AcadmeicClass::addStudentDetail Enter First Name ");
			String firstName = scan.nextLine();
			
			System.out.println("AcadmeicClass::addStudentDetail Enter Last Name ");
			String lastName = scan.nextLine();
			
			System.out.println("AcadmeicClass::addStudentDetail Enter gender ");
			// if user entered simply and move forward. It will update user with message.
			String x= scan.nextLine() ;
			if(x == "") {
				System.out.println("AcadmeicClass:: addStudentDetail  No input for Gender");
				break;
			}
				char gender = x.charAt(0);
			
			System.out.println("AcadmeicClass::addStudentDetail Enter age ");
			byte age = scan.nextByte();
			scan.nextLine();
			
			System.out.println("AcadmeicClass:: addStudentDetail Enter Marks for 5 subjects ");
			float[] marks = new float[5];
			for(int i=0; i<5; i++) {
			 marks[i] = scan.nextFloat();
			}
			System.out.println("AcadmeicClass:: addStudentDetail Enter Roll number ");
			int rollNumber = scan. nextInt();
			
			StudentAndAcadmicInfo student = new StudentAndAcadmicInfo();
			student.setAge(age);
			student.setFirstName(firstName);
			student.setLastName(lastName);
			student.setGender(gender);
			student.setMarks(marks);
			student.setRollNumber(rollNumber);
			//storing this student in arrayList
			studentList.add(student);
			
			
			System.out.println("AcadmeicClass::addStudentDetail Want to Enter More.Press Y for continue else press any char ");
			// Adding nextLine to consume \n left after rollnumber entered.(because of pressing enter and nextInt
			// doesn't consume \n)
			scan.nextLine();
			String input = scan.nextLine();
			if( input.charAt(0) != 'y'&& input.charAt(0) != 'Y' )
			{
				System.out.println("AcadmeicClass::addStudentDetail Exiting!!");
				break;
			}

			
		}while( true );
		
	}
	
	public void studentMenu()
	{
		Scanner scan = new Scanner(System.in);
		do
		{
			System.out.println("Welcome to class " + className );
			System.out.println("AcadmeicClass::studentMenu 1. Add");
			System.out.println("AcadmeicClass::studentMenu 2. Show");
			System.out.println("AcadmeicClass::studentMenu 3. Delete record by rollnumber");
			System.out.println("AcadmeicClass::studentMenu 4. Search");
			int choice = scan.nextInt();
			switch( choice )
			{
			case 1:
				addStudentDetail();
				break;
			case 2:
				showStudentDetail();
				break;
			case 3:
				deleteRecordByRollnumber();
				break;
			case 4:
				searchMenu();
				break;
				
			default:
				System.out.println("AcadmeicClass::studentMenu  Invalid choice.");
			}
			scan.nextLine();
			System.out.println("AcadmeicClass::studentMenu Want to Enter More.Press Y for continue else press any char ");

			/* 
			 * handling enter press by user inspite of giving value
			 * --storing scan.nextLine90 into String variable and put null check 
			 * if null value found, throw error and continue asking for student menu
			 * else  --> stored variable with charAt will be continued.
			 */
			String input = scan.nextLine();
			if(input == "") {
				System.out.println("AcadmeicClass::studentMenu Please enter choice");
				continue;
			}

			if( input.charAt(0) != 'y'||input.charAt(0) != 'Y' )
			{
				System.out.println("AcadmeicClass::studentMenu Exiting!!");
			}

		}while( true );
		
	}
	
	
}
