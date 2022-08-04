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
	 *  once rollnumber is received, start comparing with each objs present  inside  arraylist.
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
	
	
	public void searchMenu()
	{
		System.out.println( this.getClass().toString() + "::searchMenu:: 1.Search by Roll number " );
		System.out.println( this.getClass().toString() + "::searchMenu:: 2. Search by Full name " );
		System.out.println( this.getClass().toString() + "::searchMenu:: 3. Search by Age " );
		System.out.println( this.getClass().toString() + "::searchMenu:: 4. Search by Grade" );
		System.out.println( this.getClass().toString() + "::searchMenu:: 5. Search by Status" );
		
		 Scanner scan = new Scanner(System.in);
		int searchChoice = scan.nextInt();
		
		switch (searchChoice) {
		case 1:
			searchStudenByRollNumber(scan);
			break;
			
		case 2: 
			searchStudentByFullName(scan);
			break;
			
		case 3:
			searchStudenByAge(scan);
			break;
			
		case 4:
			searchStudentByGrade(scan);
			break;
			
		case 5:
			searchStudentByStatus(scan);
			break;

		default:
			break;
		}
		
	}
	
	// search student details by age :
	// by passing age range from user, detail of courses lies in arraylist should retrive.
	private void searchStudenByAge(Scanner scan)
	{
		System.out.println("AcadmeicClass::searchStudenByAge::Enter into search age");
		System.out.println("AcadmeicClass::searcsearchStudenByAgehMenu::Search  Age from");
		byte ageFrom = scan.nextByte();
		System.out.println("AcadmeicClass::searchStudenByAge::Search Age To");
		byte ageTo= scan.nextByte();
		boolean found = false;
		if(ageFrom>=3 && ageTo<=100) {
			for( int i=0 ; i < studentList.size(); i++ )
			{
				// checking age range should either equal to the age from or greater and smaller and equal to ageTo
				// if match age record found, return true, print details.
				if( studentList.get(i).getAge()>= ageFrom  && studentList.get(i).getAge()<= ageTo )
				{
					found = true;
					printDetail( studentList.get(i) );
				}	
	
			}	
		}
		else {
			System.out.println("AcadmeicClass::searchStudenByAge:: Age should not be <3 and >100");
		}
		if( !found )
		{	
			System.out.println(this.getClass().toString() + "::searchStudenByAge:: No student found for age between " + ageFrom + " and "+ ageTo );
		}
		System.out.println("AcadmeicClass::searchStudenByAge::existing into search  by age");
	}
	
	/*
	 * Method for searching  student records by roll number
	 */
	private void searchStudenByRollNumber(Scanner scan) {
		
		System.out.println("AcadmeicClass::searchStudenByRollNumber::Enter into search roll number");
		System.out.println("AcadmeicClass::searchStudenByRollNumber::Search  by Roll number");
		int searchRollnumber = scan.nextInt();
		boolean found = false;
		if(searchRollnumber >0) {
			for( int i=0 ; i < studentList.size(); i++ )
			{
				 if(studentList.get(i).getRollNumber() == searchRollnumber) {
					 found= true;
					 printDetail(studentList.get(i));
				 }
			}
		}
		else {
			System.out.println("AcadmeicClass::searchStudenByRollNumber:: Rollnumber cannot be < 0");
		}
		if(found == false) {
			System.out.println(this.getClass().toString() + "::searchStudenByRollNumber:: No student found for "+searchRollnumber  );
		}
		System.out.println("AcadmeicClass::searchStudenByRollNumber::existing into search by roll number");
	}
	
	/*
	 * Method to search student records by full name
	 */
	private void searchStudentByFullName(Scanner scan) {
		System.out.println("AcadmeicClass::searchStudentByFullName::Enter into search by full name");
		System.out.println("AcadmeicClass::searchStudentByFullName::Search  by full name");
		boolean found = false;
		String searchFullName;
		scan.nextLine();
			searchFullName= scan.nextLine();
			if ( searchFullName =="") {
				System.out.println("AcadmeicClass::searchStudentByFullName::Invalid input for full name");
			}
			else {
				for( int i=0 ; i < studentList.size(); i++ )
				{
					 if(studentList.get(i).getFullName().equals(searchFullName)) {
						 found= true;
						 printDetail(studentList.get(i));
					 }
				}
			}
			if(found == false) {
				System.out.println(this.getClass().toString() + "::searchStudentByFullName:: No student found for "+searchFullName  );
			}
		System.out.println("AcadmeicClass::searchStudentByFullName::existing into search by full name");
	}
	
	/*
	 * Method for searching  student records by Status
	 */
	private void searchStudentByStatus(Scanner scan) {
		
		System.out.println("AcadmeicClass::searchStudentByStatus::Enter into search by Status");
		System.out.println("AcadmeicClass::searchStudentByStatus::Search  by Status");
		scan.nextLine();
		String searchStatus = scan.nextLine();
		// converting first char of string into capital.because in get grade class, values set as 'Fail' and 'Pass'
		String searchStatus1 = Character.toUpperCase(searchStatus.charAt(0))+ searchStatus.substring(1);
		boolean found = false;
		System.out.println("input"+ searchStatus1);
		for( int i=0 ; i < studentList.size(); i++ )
		{
			 if(studentList.get(i).getStatus().equals(searchStatus1)) {
				 found= true;
				 System.out.println("Found value" + found);
				 printDetail(studentList.get(i));
			 }
		}
		 System.out.println("Found value" + found);
		if(found == false) {
			System.out.println(this.getClass().toString() + "::searchStudentByStatus:: No student found for "+searchStatus1  );
		}
		System.out.println("AcadmeicClass::searchStudentByStatus::existing into search by Status");
	}
	
	/*
	 * Method for searching  student records by Grade
	 */
	private void searchStudentByGrade(Scanner scan) {
		
		System.out.println("AcadmeicClass::searchStudentByGrade::Enter into search by grade");
		System.out.println("AcadmeicClass::searchStudentByGrade::Search  by grade");
		boolean found = false;
		char searchGrade = 0;
		scan.nextLine();
		String x= scan.nextLine();
		if(x =="") {
			System.out.println("AcadmeicClass::searchStudentByGrade::Invalid input for grade");
		}
		else {
		 searchGrade = x.charAt(0);
		 char searchGrade1 = Character.toUpperCase(searchGrade);
			for( int i=0 ; i < studentList.size(); i++ )
			{
				 if(studentList.get(i).getGrade() == searchGrade1) {
					 found= true;
					 printDetail(studentList.get(i));
				 }
			}
		}
		if(found == false) {
			System.out.println(this.getClass().toString() + "::searchStudentByGrade:: No student found for "+searchGrade);
		}
		System.out.println("AcadmeicClass::searchStudentByGrade::existing into search by Grade");
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
