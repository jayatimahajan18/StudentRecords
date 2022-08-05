package myPkg;

/**
 * 
 * Goal: Create an application for student academic record management
 * Features:
 * 1. User is able to add student records
 * 		Input: First Name, Last Name, Age, Gender, Marks for 5 Subjects, Roll Number
 * 2.User is able to delete record of student by roll number
 * 3. User is able to see list of all students with all details except marks, first name and last name
 * 		3.1 Some additional details should be displayed too
 * 			a. Grade : If Perc > 90 : A
 * 							>70-90: B
 * 							>50-70 : C
 * 							>33.3-50 :D 
 * 							else: F
 * 			b. Divison I : >60 II: 33.3-60 else NA
 * 			c. Status: Pass/Fail
 * 			d. Full Name
 * 4. User is able to search student by and show details mentioned on #3:
 * 		a. Roll Number
 * 		b. Full Name
 * 		c. Age Range[ Start and End ]
 * 		d. Grade
 * 		e. Status
 * 5. Show Toppers [top 5 ]
 * 6. Show Toppers for specfic Age [ex 15yrs] 
 * 7. Make rollnumber should be unique
 * 		
 * 
 * @author ishug
 *
 */

public class Main {
	public static void main(String args[])
	{
		System.out.println("Hello abc World!!!!!!!");
		//To DO:: 
		AcadmeicClass classV = new AcadmeicClass(" Class V");
		classV.studentMenu();
		
		
	}
}
