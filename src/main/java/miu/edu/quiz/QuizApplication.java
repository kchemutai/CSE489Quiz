package miu.edu.quiz;

import lombok.RequiredArgsConstructor;
import miu.edu.quiz.model.Employee;
import miu.edu.quiz.service.EmployeeService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
@RequiredArgsConstructor
public class QuizApplication implements CommandLineRunner {

	private final EmployeeService employeeService;

	public static void main(String[] args) {
		SpringApplication.run(QuizApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Employee employee1 = new Employee(1, "John", "Doe", 50000L);
		Employee employee2 = new Employee(2, "Jane", "Dona", 50000L);
		Employee employee3 = new Employee(3, "Alice", "Smith", 60000L);
		Employee employee4 = new Employee(4, "Bob", "Brown", 45000L);
		employeeService.save(employee1);
		employeeService.save(employee2);
		employeeService.save(employee3);
		employeeService.save(employee4);

		employeeService.findAll().stream().sorted(Comparator.comparing(Employee::getLastName)
				.thenComparing(Comparator.comparing(Employee::getFirstName))).forEach(System.out::println);
	}
}
