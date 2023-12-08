package com.bootcamp.employeesystemapi.controllers;

import com.bootcamp.employeesystemapi.models.Employee;
import com.bootcamp.employeesystemapi.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController("/api")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/")
    public String viewHomePage(Model model) {
        model.addAttribute("listEmployees", employeeService.getAllEmployees());
        return "index";
    }

    @GetMapping("/showNewEmployeeForm")
    public String showNewEmployeeForm(Model model) {
// Create model attribute to bind form data
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return "new_employee.html";
    }

    @PostMapping("/saveEmployee")
    public String
    saveEmployee(@ModelAttribute("employee") Employee
                         employee) {
        employeeService.saveEmployee(employee);
        return "redirect:/";
    }

    @GetMapping("/showFormForUpdate/{id}")
    public String
    showFormForUpdate(@PathVariable(value="id") long id,
                      Model model) {
        Employee employee =
                employeeService.getEmployeeById(id);
        model.addAttribute("employee", employee);
        return "update_employee";
    }

    @GetMapping("/deleteEmployee/{id}")
    public String deleteEmployee(@PathVariable (value =
            "id") long id) {
        this.employeeService.deleteEmployeeById(id);
        return "redirect:/";
    }

    @PutMapping({"/{employeeId}"})
    public ResponseEntity<Employee> updateEmployee(@PathVariable("employeeId") Long employeeId, @RequestBody Employee employee) {
        employeeService.updateEmployee(employeeId, employee);
        return new ResponseEntity<>(employeeService.getEmployeeById(employeeId), HttpStatus.OK);
    }

}
