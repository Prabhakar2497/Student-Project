package com;

import java.util.ArrayList;
import java.util.Collections;

public class TestEmlpoyee {
public static void main(String[] args) {
	Employee e1=new Employee(200);
	Employee e2=new Employee(300);
	Employee e3=new Employee(100);
	ArrayList<Employee>l=new ArrayList<>();
	l.add(e1);
	l.add(e2);
	l.add(e3);
	Collections.sort(l,new SortEmployeeById());
	for(Employee emp:l) {
		System.out.println(emp);
	}
	
}
}
