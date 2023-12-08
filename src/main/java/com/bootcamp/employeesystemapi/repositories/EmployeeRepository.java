package com.bootcamp.employeesystemapi.repositories;

import com.bootcamp.employeesystemapi.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
