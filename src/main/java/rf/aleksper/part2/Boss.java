package rf.aleksper.part2;

import rf.aleksper.part1.Employee;

import java.util.List;

public class Boss extends Employee {
	boolean boss;

	public Boss(String fullName, String position, String phone, int salary, int age, boolean boss) {
		super(fullName, position, phone, salary, age);
		this.boss = boss;
	}

	public boolean isBoss() {
		return this.boss;
	}

	public void increaseInSalary(List<Employee> employees, int Age, int increaseInSalary) {
		for (Employee employee : employees) {
			if (employee.getAge() > age || !boss ) {
				employee.setSalary(employee.getSalary() + increaseInSalary);
			}
		}
	}
}
