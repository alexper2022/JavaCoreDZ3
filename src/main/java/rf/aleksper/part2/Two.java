package rf.aleksper.part2;

import rf.aleksper.part1.Employee;

import java.util.List;

/*
Опишите класс руководителя, наследник от сотрудника. Перенесите статический метод
повышения зарплаты в класс руководителя, модифицируйте метод таким образом,
чтобы он мог поднять заработную плату всем, кроме руководителей. В основной
программе создайте руководителя и поместите его в общий массив сотрудников.
Повысьте зарплату всем сотрудникам и проследите, чтобы зарплата руководителя
не повысилась.
 */
public class Two {
	public static void run(List<Employee> employees, Boss boss, int age, int increaseInSalary){
		boss.increaseInSalary(employees,age,increaseInSalary);
	}
}
