package rf.aleksper.part1;

import java.util.Objects;

public class Employee {
	protected String fullName;
	protected String position;
	protected String phone;
	protected int salary;
	protected int age;

	public Employee(String fullName, String position, String phone, int salary, int age) {
		this.fullName = fullName;
		this.position = position;
		this.phone = phone;
		this.salary = salary;
		this.age = age;
	}

	//---------------------------------------------------------------------------------------
	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	//---------------------------------------------------------------------------------------
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Employee employee)) return false;
		return getPhone() == employee.getPhone()
				&& getSalary() == employee.getSalary()
				&& getAge() == employee.getAge()
				&& Objects.equals(getFullName(), employee.getFullName())
				&& Objects.equals(getPosition(), employee.getPosition());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getFullName(), getPosition(), getPhone(), getSalary(), getAge());
	}
//---------------------------------------------------------------------------------------

	@Override
	public String toString() {
		return "Name: " + fullName + ", position: " + position +
				", phone: " + phone +
				", salary: " + salary +
				", age: " + age;
	}

//---------------------------------------------------------------------------------------
	public void increaseInSalary(int age, int increaseInSalary) {
		if (getAge() > age) {
			setSalary(getSalary() + increaseInSalary);
		}
	}

}
