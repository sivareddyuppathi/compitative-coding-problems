package com.coding.java8to12;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ConvertListToMapUsingGGropuBy {
	public static void main(String[] args) {
		List<Employee> empList = new ArrayList<>();

		crateEmployee(empList);

		Map<String, List<Employee>> empMap = empList.stream().collect(Collectors.groupingBy(Employee::getCity));
		empMap.forEach((key, value) -> {
			System.out.println(key + ":" + value);
		});

	}

	private static void crateEmployee(List<Employee> empList) {

		Employee e1 = new Employee();
		e1.setId(0);
		e1.setName("A");
		e1.setCity("Hyd");

		Employee e2 = new Employee();
		e1.setId(1);
		e1.setName("B");
		e1.setCity("Hyd");

		Employee e3 = new Employee();
		e1.setId(2);
		e1.setName("C");
		e1.setCity("Hyd");

		Employee e4 = new Employee();
		e1.setId(3);
		e1.setName("D");
		e1.setCity("Beng");

		Employee e5 = new Employee();
		e1.setId(4);
		e1.setName("E");
		e1.setCity("Beng");

		empList.add(e5);
		empList.add(e4);
		empList.add(e3);
		empList.add(e2);
		empList.add(e1);

	}
}

class Employee {
	private int id;
	private String name;
	private String city;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

}
