package rf.aleksper.part1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 - Создать класс ”Сотрудник” с полями: ФИО, должность, телефон, зарплата, возраст.
 - Написать метод выводящий всю доступную информацию об объекте с использованием
   форматирования строк.
 - Создать массив из 5 сотрудников
 - Создать метод, повышающий зарплату всем сотрудникам старше 45 лет на 5000.
   Возраст и размер повышения должны быть параметрами метода.
 - Написать тот же метод повышения в качестве статического в классе сотрудника.
   Метод должен принимать в качестве параметра массив сотрудников.
 - Написать методы (принимающие на вход массив сотрудников), вычисляющие средний
   возраст и среднюю зарплату сотрудников, вывести результаты работы в консоль.
 */
public class One {
	public static void run() {
		List<Employee> employees = new ArrayList<Employee>();
		Employee employee1 = new Employee("Pupkin Vasiliy Evgrafovich", "Manageer",
				"+79889881234", 100000, 25);
		Employee employee2 = new Employee("Ivanov Sidor Petrovich", "Manageer",
				"+79889881234", 100000, 35);
		Employee employee3 = new Employee("Petrov Vasiliy Evgrafovich", "Manageer",
				"+79889881234", 100000, 46);
		Employee employee4 = new Employee("Sidorov Vasiliy Evgrafovich", "Manageer",
				"+79889881234", 100000, 55);
		Employee employee5 = new Employee("Vasiliev Vasiliy Evgrafovich", "Manageer",
				"+79889881234", 100000, 60);
//----------------------------------------------------------------------------------------------------
// Создаем 5 сотрудников
		employees.add(employee1);
		employees.add(employee2);
		employees.add(employee3);
		employees.add(employee4);
		employees.add(employee5);
//----------------------------------------------------------------------------------------------------
// Выводим информацию о сотруднике с помощью встроенного метода toString()
		System.out.println("\nВыводим информацию о сотруднике с помощью встроенного метода toString()");
		for (Employee employee : employees) {
			System.out.println(employee.toString());
		}
//----------------------------------------------------------------------------------------------------
// Выводим информацию о сотруднике с помощью специального метода не встроенного в класс
		System.out.printf("%nВыводим информацию о сотруднике с помощью специального метода не встроенного в класс");
		for (Employee employee : employees) {
			printEmployeeInfo(employee);
		}
//----------------------------------------------------------------------------------------------------
// Добавляем зарплату сотрудникам у которых возраст больше 45 на 5000
		for (Employee employee : employees) {
			increaseInSalary(employee, 45, 5000);
		}
//----------------------------------------------------------------------------------------------------
// Выводим информацию о сотруднике с помощью специального метода не встроенного в класс
		System.out.printf("%nВыводим информацию о сотруднике после добавления зарплаты не встроенным в класс методом");
		System.out.println();
		for (Employee employee : employees) {
			System.out.println(employee.toString());
		}

//----------------------------------------------------------------------------------------------------
// Добавляем зарплату сотрудникам у которых возраст больше 45 на 5000
// с помощью статического метода сотрудника
		for (Employee employee : employees) {
			employee.increaseInSalary(45, 5000);
		}
//----------------------------------------------------------------------------------------------------
// Выводим информацию о сотруднике с помощью специального метода не встроенного в класс
		System.out.printf("%nВыводим информацию о сотруднике после добавления зарплаты встроенным в класс методом%n");
		for (Employee employee : employees) {
			System.out.println(employee.toString());
		}
		System.out.printf("%nСредний возраст: %d\n", arithmeticMeanEmployeeAge(employees));
		System.out.printf("Средняя зарплата: %d\n", arithmeticMeanEmployeeSalary(employees));
	}



	protected static void printEmployeeInfo(Employee employee) {
		System.out.printf("%nFIO: %s %nposition: %s, phone: %s %nsalary: %d, age: %d %n",
				employee.getFullName(),
				employee.getPosition(),
				employee.getPhone(),
				employee.getSalary(),
				employee.getAge()
		);
	}

	protected static void increaseInSalary(Employee employee, int age, int increaseInSalary) {
		if (employee.getAge() > age) {
			employee.setSalary(employee.getSalary() + increaseInSalary);
		}
	}

	public static long arithmeticMeanEmployeeAge(List<Employee> employees){
		int summAge = 0;
		for (Employee employee:	employees) {
			summAge = summAge + employee.getAge();

		}
		return summAge / employees.stream().count();

	}
	public static long arithmeticMeanEmployeeSalary(List<Employee> employees){

		int summSalary = 0;
		for (Employee employee:	employees) {
			summSalary = summSalary + employee.getSalary();

		}
		return summSalary / employees.stream().count();

	}


}
