package sdbms;

import java.security.cert.CollectionCertStoreParameters;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.Set;

public class StudentManagementSystemImpl implements StudentManagementSystem {
	Scanner sc=new Scanner(System.in);
	LinkedHashMap<Integer, Student> db=new LinkedHashMap<>();
	@Override
	public void addStudent() {	
		System.out.println("Enter Id,Name,Age,Marks");
		int id=sc.nextInt();
		String name=sc.next();
		int age=sc.nextInt();
		double marks=sc.nextDouble();
		Student std=new Student(id, name, age, marks);
		db.put(id, std);
		System.out.println("Student Record Inserted Successfully");
	}
	@Override
	public void removeStudent() {
		System.out.println("Enter The Student Id:");
		int id=sc.nextInt();
		if(db.containsKey(id)) {
			db.remove(id);
			System.out.println("Student Record Deleted");
		}
		else {
			try {
				throw new StudentNotFoundException("Student Data Not Found!");
			}
			catch(StudentNotFoundException e) {
				System.out.println(e.getMessage());
			}
		}
	}

	@Override
	public void removeAllStudents() {
		db.clear();
		System.out.println("Student Records Deleted Successfully");
	}

	@Override
	public void displayStudent() {
		System.out.println("Enter The Student Id:");
		int id=sc.nextInt();
		if(db.containsKey(id)) {
		Student std=db.get(id);///Student std=new Student();
		System.out.println(std);//Since toString is Overridden
		/*System.out.println("Id:"+std.getId());
		System.out.println("Age:"+std.getAge());
		System.out.println("Name:"+std.getName());
		System.out.println("Marks:"+std.getMarks());*/
		
	}
		else {
			try{
				throw new StudentNotFoundException("Student Data Not Found!");
			}
		
		catch(StudentNotFoundException e) {
			System.out.println(e.getMessage());
		}
		}
	}
	@Override
	public void displayAllStudents() {
		Set<Integer> s=db.keySet();
		for(int a:s) {
			System.out.println(db.get(a));
		}
	}

	@Override
	public void updateStudent() {
		System.out.println("Enter The Student Id:");
		int id=sc.nextInt();
		if(db.containsKey(id)) {
			Student std=db.get(id);
	System.out.println("1:Update Name:\n2:Update Age:\n3:Update Marks:");
System.out.println("Enter The Choice");
int choice=sc.nextInt();
switch(choice) {
case 1:
	System.out.println("Enter The Name");
	String name=sc.next();
	std.setName(name);
	System.out.println("Student Name Updated");
	break;
case 2:
	System.out.println("Enter The Age");
	int age=sc.nextInt();
	std.setAge(age);
	System.out.println("Student Age Updated");
	break;
case 3:
	System.out.println("Enter The Marks");
	double marks=sc.nextDouble();
	std.setMarks(marks);
	System.out.println("Student Marks Updated");
	break;
	default:
		System.out.println("Invalid Choice");
}
		}
else {
	try{
		throw new StudentNotFoundException("Student Data Not Found!");
	}
	catch(StudentNotFoundException e) {
		System.out.println(e.getMessage());
	}
}
		
	}

	@Override
	public void countStudents() {
		System.out.println("Count of Students Present:"+db.size());
	}

	@Override
	public void sortStudents() {
		ArrayList<Student>l=new ArrayList<>();
		Set<Integer>s=db.keySet();
		for(int id:s) {
			l.add(db.get(id));
		}
		System.out.println("1:Sort Based On Id\n2:Sort Based On Name");
		System.out.println("3:Sort Based On Age\n4:Sort Based On Marks");
		System.out.println("Enter The Choice");
		int choice=sc.nextInt();
		switch(choice) {
		case 1:
			Collections.sort(l,new SortStudentById());
			for(Student s1:l) {//display(l);
				System.out.println(s1);
			}
			break;
		case 2:
			Collections.sort(l,new SortStudentByName());
			for(Student s2:l) {  //display(l);
				System.out.println(s2);
			}
			break;
			case 3:
				Collections.sort(l,new SortStudentByAge());
				for(Student s3:l) {    //display(l);
					System.out.println(s3);
				}
				break;
			case 4:
				Collections.sort(l,new SortStudentByMarks());
				for(Student s4:l) {     //display(l);
					System.out.println(s4);
				}
					break;
					default:
						System.out.println("Invalid Choice");
				
		}
	}

/*private static void display(List<Student>l){
	for(Student s1:l) {
		System.out.println(s1);
	}
}*/
        }