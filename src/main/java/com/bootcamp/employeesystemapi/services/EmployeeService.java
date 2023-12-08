package com.bootcamp.employeesystemapi.services;

import com.bootcamp.employeesystemapi.models.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployees();
    void saveEmployee(Employee employee);
    Employee getEmployeeById(long id);
    void updateEmployee(Long id, Employee employee);
    void deleteEmployeeById(long id);
}
