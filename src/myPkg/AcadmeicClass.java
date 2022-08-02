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
		//TO DO: Fill Rest of code
		System.out.println("AcadmeicClass::printDetail Student Details Started \n");
		System.out.println("Name: " + obj.getFullName() );
		System.out.println("Age: " + obj.getAge() );
		System.out.println("Gender: " + obj.getGender() );
		System.out.println("AcadmeicClass::printDetail Student Details Ended \n");

	}
	private void showStudentDetail()
	{
		for( int i=0 ; i < studentList.size(); i++ )
		{
			printDetail( studentList.get(i) );
		}	
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
			//TO DO: Take input for marks and Roll no and add sysout statemetns
			System.out.println("AcadmeicClass::addStudentDetail Enter First Name ");
			String firstName = scan.nextLine();
			System.out.println("AcadmeicClass::addStudentDetail Enter Last Name ");
			
			String lastName = scan.nextLine();
			System.out.println("AcadmeicClass::addStudentDetail Enter gender ");
			//To DO: Handle Error Case
			char gender = scan.nextLine().charAt(0);
			System.out.println("AcadmeicClass::addStudentDetail Enter age ");

			byte age = scan.nextByte();
			scan.nextLine();
			StudentAndAcadmicInfo student = new StudentAndAcadmicInfo();
			student.setAge(age);
			student.setFirstName(firstName);
			student.setLastName(lastName);
			student.setGender(gender);
			//storing this student in arrayList
			studentList.add(student);
			
			System.out.println("AcadmeicClass::addStudentDetail Want to Enter More.Press Y for continue else press any char ");
			String input = scan.nextLine();
			//To DO: Handle Error Case
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
			//TO DO: Take input for marks and Roll no and add sysout statemetns
			System.out.println("AcadmeicClass::studentMenu Option you want to select 1 for add, 2 show, 3 for search  ");
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
				searchMenu();
			}
			scan.nextLine();
			System.out.println("AcadmeicClass::studentMenu Want to Enter More.Press Y for continue else press any char ");

			String input = scan.nextLine();
			//To DO: Handle Error Case

			if( input.charAt(0) != 'y'||input.charAt(0) != 'Y' )
			{
				System.out.println("AcadmeicClass::studentMenu Exiting!!");
			}

		}while( true );
		
	}
	
}
