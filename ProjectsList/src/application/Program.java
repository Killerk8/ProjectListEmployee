package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.Employee;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		List<Employee> list = new ArrayList<>();
		
		System.out.println("How many employees will be registered? ");
		int N = sc.nextInt();
		
		for (int i=0; i<N; i++) {
			System.out.println();
			System.out.println("Employee #" + (i+1) + ":");
			System.out.print("Id: ");
			Integer id = sc.nextInt();
			
			while (hasId(list, id)) {
				System.out.println("Id already taken! Try again:");
			}
			
			System.out.print("Name: ");
			sc.nextLine();
			String name = sc.nextLine();
			
			System.out.print("Salary: ");
			Double salary = sc.nextDouble();
			
			Employee emp = new Employee(id, name, salary);
			list.add(emp);
			
		}
		
		System.out.println();
		
		System.out.println("Enter the employee id that will have salary increase : ");
		int id = sc.nextInt();
		
		Employee emp = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
		
		//Integer pos = position(list, id);
		if (emp == null) {
			System.out.print("This id does not exist !");
			
			System.out.println("List of employess:");
			for (Employee x : list) {
				System.out.println(x);		
			}
			
		}else {	
				System.out.print("Enter the percentage: ");
				double percent = sc.nextDouble();
				emp.increaseSalary(percent);
				
				System.out.println();
				for (Employee x : list) {
					System.out.println(x);		
				}
				
			}
}
	
	public static Integer position(List<Employee> list, int id) {
		for (int i=0; i<list.size(); i++) {
			if (list.get(i).getId() == id)
				return i;
		}
		return null;
	}
	
	public static boolean hasId(List<Employee> list, int id) {
		Employee emp = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
		return emp != null;
	}
}




