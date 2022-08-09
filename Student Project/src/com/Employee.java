package com;

public class Employee {
int id;

public Employee(int id) {
	this.id = id;
}

@Override
public String toString() {
	return "Id:"+id;
}

}
