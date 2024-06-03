package miu.edu.quiz.service;

import lombok.RequiredArgsConstructor;
import miu.edu.quiz.model.Employee;
import miu.edu.quiz.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee findById(int id) {
        return employeeRepository.findById(id).get();
    }

    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }
    public void deleteById(int id) {
        employeeRepository.deleteById(id);
    }

    public Employee update(Employee employee) {
        Optional<Employee> employeeOptional = employeeRepository.findById(employee.getId());
        Employee updatedEmployee = null;
        if (employeeOptional.isPresent()) {
            updatedEmployee = employeeRepository.save(employee);
        }
        return updatedEmployee;
    }
}
