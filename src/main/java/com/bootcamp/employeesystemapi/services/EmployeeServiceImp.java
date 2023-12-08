package com.bootcamp.employeesystemapi.services;

import com.bootcamp.employeesystemapi.models.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bootcamp.employeesystemapi.repositories.EmployeeRepository;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImp implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public void saveEmployee(Employee employee) {
        this.employeeRepository.save(employee);
    }

    @Override
    public Employee getEmployeeById(long id) {
        Optional<Employee> optional = Optional.of(employeeRepository.findById(id).get());
        Employee employee;
        if (optional.isPresent()) {
            employee = optional.get();
        } else {
            throw new RuntimeException("Employee not found for id :: " + id);
        }
        return employee;
    }

    @Override
    public void updateEmployee(Long id, Employee employee) {
       Employee employeeFromDb = employeeRepository.findById(id).get();
         System.out.println(employeeFromDb.toString());

            employeeFromDb.setFirstName(employee.getFirstName());
            employeeFromDb.setLastName(employee.getLastName());
            employeeFromDb.setEmail(employee.getEmail());
            employeeRepository.save(employeeFromDb);
    }

    @Override
    public void deleteEmployeeById(long id) {
        this.employeeRepository.deleteById(id);
    }

}
