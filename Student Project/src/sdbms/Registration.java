package sdbms;

import java.util.Scanner;

public class Registration {
public static void main(String[] args) {
	Scanner scan=new Scanner(System.in);
	System.out.println("Welcome To SDBMS");
	System.out.println("-----------");
	//UPCASTING->ABSTRACTION
	StudentManagementSystem obj=new StudentManagementSystemImpl();
	//Menu Driven Program
	while(true) {
	System.out.println("1:ADD STUDENT\n2:REMOVE STUDENT");
	System.out.println("3:REMOVE ALL STUDENTS STUDENT\n4:DISPLAY STUDENT");
	System.out.println("5:DISPLAY ALL STUDENTS\n6:UPDATE STUDENT");
	System.out.println("7:COUNT STUDENTS\n8:SORT STUDENTS\n9:EXIT");
	System.out.println("Enter The Choice");
	int choice=scan.nextInt();
	switch(choice) {
	case 1:
		obj.addStudent();
	break;
	case 2:
		obj.removeStudent();
	break;
	case 3:
		obj.removeAllStudents();
		 
	break;
	case 4:
		obj.displayStudent();
	break;
	case 5:
		obj.displayAllStudents();
	break;
	case 6:
		obj.updateStudent();
	break;
	case 7:
		obj.countStudents();
	break;
	case 8:
		obj.sortStudents();
	break;																	
	case 9:
		 System.out.println("Thank You!!");
		 System.exit(0);
		 default:
			 System.out.println("Enter The Valid Choice");
	}
	System.out.println("-----------");
}
}
}	
 