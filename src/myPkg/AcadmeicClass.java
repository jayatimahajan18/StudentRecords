package myPkg;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class AcadmeicClass {
	private ArrayList<StudentAndAcadmicInfo> studentList;
	List<StudentAndAcadmicInfo> searchbyAgeList = new ArrayList<>();
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
		System.out.println("Status." + obj.getStatus());
		System.out.println("Division." + obj.getDivision());
		
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
	private  void deleteRecordByRollnumber(int rollnumberToDelete) {
  
		System.out.println("AcadmeicClass::deleteRecordByRollnumber entering into method");
		System.out.println("AcadmeicClass::deleteRecordByRollnumber Enter rollnumber to be delete");
		int flag=0;
		for(int i=0; i< studentList.size(); i++) {
			if( rollnumberToDelete == studentList.get(i).getRollNumber()){
				studentList.remove(i);
				flag++;
				System.out.println("AcadmeicClass::deleteRecordByRollnumber Delete of record for  " + rollnumberToDelete + " is successfull");
				break;
			}				
		}
		if(flag ==0) {
			System.out.println("AcadmeicClass::deleteRecordByRollnumber No record present with this  " + rollnumberToDelete);
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
			System.out.println("AcadmeicClass::searchStudenByRollNumber::Search  by Roll number");
			int searchRollnumber = scan.nextInt();
			searchStudenByRollNumber(searchRollnumber);
			break;
			
		case 2: 
			System.out.println("AcadmeicClass::searchStudentByFullName::Search  by full name");
			scan.nextLine();
			String searchFullName= scan.nextLine();
			searchStudentByFullName(searchFullName);
			break;
			
		case 3:
			System.out.println("AcadmeicClass::searchStudenByRollNumber::Enter into search roll number");
			byte ageFrom = scan.nextByte();
			System.out.println("AcadmeicClass::searchStudenByAge::Search Age To");
			byte ageTo= scan.nextByte();
			searchStudenByAge(ageFrom, ageTo);
			break;
			
		case 4:
			System.out.println("AcadmeicClass::searchStudentByGrade::Search  by grade");
			char searchGrade = 0;
			scan.nextLine();
			String x= scan.nextLine();
			if(x =="") {
				System.out.println("AcadmeicClass::searchStudentByGrade::Invalid input for grade");
			}
			else {
				 searchGrade = x.charAt(0);
				 char searchGrade1 = Character.toUpperCase(searchGrade);
				 searchStudentByGrade(searchGrade1);
			}
			break;
			
		case 5:
			System.out.println("AcadmeicClass::searchStudentByStatus::Search  by Status");
			scan.nextLine();
			String searchStatus = scan.nextLine();
			// converting first char of string into capital.because in get grade class, values set as 'Fail' and 'Pass'
			String searchStatus1 = Character.toUpperCase(searchStatus.charAt(0))+ searchStatus.substring(1);
			searchStudentByStatus(searchStatus1);
			break;

		default:
			System.out.println(this.getClass().toString()+ "::searchMenu:: Invalid input for search");
			break;
		}
	}
		
	
	// search student details by age :
	// by passing age range from user, detail of courses lies in arraylist should retrive.
	private void searchStudenByAge(int ageFrom,int ageTo)
	{
		System.out.println("AcadmeicClass::searchStudenByAge::Enter into search age");
		boolean found = false;
		if(ageFrom>=3 && ageTo<=100) {
			for( int i=0 ; i < studentList.size(); i++ )
			{
				// checking age range should either equal to the age from or greater and smaller and equal to ageTo
				// if match age record found, return true, print details.
				if( studentList.get(i).getAge()>= ageFrom  && studentList.get(i).getAge()<= ageTo )
				{
					found = true;
					printSearchResult(studentList.get(i));
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
	 * Printing the list of search records by search menu
	 */
	private void printSearchResult (StudentAndAcadmicInfo searchbyAgeobj) {
		searchbyAgeList.clear();
		searchbyAgeList.add(searchbyAgeobj);
		//System.out.println("Size of new list  "+ searchbyAgeList.size());
		if(searchbyAgeList.size()>0) {
			for( int i=0; i< searchbyAgeList.size(); i++) {
			printDetail(searchbyAgeList.get(i));
			}
		}
	}
	
	
	/*
	 * Method for searching  student records by roll number
	 */
	private void searchStudenByRollNumber(int searchRollnumber) {
		
		System.out.println("AcadmeicClass::searcsearchStudenByAgehMenu::Entered into search by rollnumber");
		boolean found = false;
		//int flag=0;
		if(searchRollnumber >0) {
			for( int i=0 ; i < studentList.size(); i++ )
			{
				 if( searchRollnumber ==studentList.get(i).getRollNumber()) {
					 found= true;
					// flag++;
					 printSearchResult(studentList.get(i));
					 break;
				 }
			}
			//System.out.println("loop run in search by rollnumber   " + flag);
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
	private void searchStudentByFullName(String searchFullName) {
		System.out.println("AcadmeicClass::searchStudentByFullName::Enter into search by full name");
		
		boolean found = false;
			if ( searchFullName =="") {
				System.out.println("AcadmeicClass::searchStudentByFullName::Invalid input for full name");
			}
			else {
				for( int i=0 ; i < studentList.size(); i++ )
				{
					 if(studentList.get(i).getFullName().equals(searchFullName)) {
						 found= true;
						 printSearchResult(studentList.get(i));
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
	private void searchStudentByStatus(String searchStatus1) {
		
		System.out.println("AcadmeicClass::searchStudentByStatus::Enter into search by Status");
		boolean found = false;
		System.out.println("input"+ searchStatus1);
		for( int i=0 ; i < studentList.size(); i++ )
		{
			 if(studentList.get(i).getStatus().equals(searchStatus1)) {
				 found= true;
				 //System.out.println("Found value" + found);
				 printSearchResult(studentList.get(i));
			 }
		}
		// System.out.println("Found value" + found);
		if(found == false) {
			System.out.println(this.getClass().toString() + "::searchStudentByStatus:: No student found for "+searchStatus1  );
		}
		System.out.println("AcadmeicClass::searchStudentByStatus::existing into search by Status");
	}
	
	/*
	 * Method for searching  student records by Grade
	 */
	private void searchStudentByGrade(char searchGrade1) {
		
		System.out.println("AcadmeicClass::searchStudentByGrade::Enter into search by grade");
		boolean found = false;
		
			for( int i=0 ; i < studentList.size(); i++ )
			{
				 if(studentList.get(i).getGrade() == searchGrade1) {
					 found= true;
					 printSearchResult(studentList.get(i));
				 }
			}
		if(found == false) {
			System.out.println(this.getClass().toString() + "::searchStudentByGrade:: No student found for "+searchGrade1);
		}
		System.out.println("AcadmeicClass::searchStudentByGrade::existing into search by Grade");
	}
	
	/*
	 * Show toppers list from the student records
	 */
	private void showToppers() {
		
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
			System.out.println("AcadmeicClass::studentMenu 5. Show Toppers");
			int choice = scan.nextInt();
			scan.nextLine();
			switch( choice )
			{
			case 1:
				addStudentDetail();
				break;
			case 2:
				showStudentDetail();
				break;
			case 3:
				Scanner scan1 = new Scanner(System.in);
				int rollnumberToDelete = scan.nextInt();
				deleteRecordByRollnumber(rollnumberToDelete);
				break;
			case 4:
				searchMenu();
				break;
			case 5:
				showToppers();
				break;
			default:
				System.out.println("AcadmeicClass::studentMenu  Invalid choice.");
			}
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
