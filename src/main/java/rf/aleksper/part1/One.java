package rf.aleksper.part1;

import rf.aleksper.part2.Boss;
import rf.aleksper.part2.Two;

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
//----------------------------------------------------------------------------------------------------
// Создаем 5 сотрудников
		System.out.println("\nСоздаем 5 сотрудников");
		List<Employee> employees = new ArrayList<Employee>();
		Employee employee1 = new Employee("Pupkin Vasiliy Evgrafovich", "Manager",
				"+79889881234", 100000, 25);
		Employee employee2 = new Employee("Ivanov Sidor Petrovich", "Manager",
				"+79889882345", 100000, 35);
		Employee employee3 = new Employee("Petrov Ivan Fedorovich", "Manager",
				"+79889883456", 100000, 45);
		Employee employee4 = new Employee("Sidorov Nikolay Nikolaevich", "Manager",
				"+79889884567", 100000, 55);
		Employee employee5 = new Employee("Vasiliev Vasiliy Vasilievich", "Manager",
				"+79889885678", 100000, 60);
//----------------------------------------------------------------------------------------------------
// Добавляем всех сотрудников в массив
		System.out.println("\nДобавляем всех сотрудников в массив");
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
		System.out.printf("%nВыводим информацию о сотруднике с помощью специального метода не встроенного" +
				"в класс");
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
		System.out.printf("%nВыводим информацию о сотруднике после добавления зарплаты не встроенным" +
				" в класс методом");
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
		System.out.printf("%nВыводим информацию о сотруднике после добавления зарплаты встроенным" +
				" в класс методом%n");
		for (Employee employee : employees) {
			System.out.println(employee.toString());
		}
//----------------------------------------------------------------------------------------------------
// Выводим средний возраст и среднюю зарплату
		System.out.println("\nВыводим средний возраст и среднюю зарплату");
		System.out.printf("Средний возраст: %d\n", arithmeticMeanEmployeeAge(employees));
		System.out.printf("Средняя зарплата: %d\n", arithmeticMeanEmployeeSalary(employees));

//----------------------------------------------------------------------------------------------------
// Создаем сотрудника-руководителя, добавляем его в массив сотрудников и начисляем зарплату встроенным
// в класс Boss методом
		System.out.println("\nСоздаем сотрудника-руководителя, добавляем его в массив сотрудников и\n" +
				"начисляем зарплату встроенным в класс Boss методом");
		Boss boss = new Boss("Babich Nikolay Vasilievich", "Boss",
				"+79998887654", 200000, 47, true);
		employees.add(boss);
		Two.run(employees, boss, 45, 7500);

//----------------------------------------------------------------------------------------------------
// Выводим Итоговую информацию о сотрудниках с помощью встроенного в класс toString()
		System.out.println("Выводим Итоговую информацию о сотрудниках с помощью встроенного в класс toString()");
		for (Employee employee : employees) {
			System.out.println(employee.toString());
		}
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

	public static long arithmeticMeanEmployeeAge(List<Employee> employees) {
		int summAge = 0;
		for (Employee employee : employees) {
			summAge = summAge + employee.getAge();

		}
		return summAge / employees.stream().count();

	}

	public static long arithmeticMeanEmployeeSalary(List<Employee> employees) {

		int summSalary = 0;
		for (Employee employee : employees) {
			summSalary = summSalary + employee.getSalary();

		}
		return summSalary / employees.stream().count();
	}


}
