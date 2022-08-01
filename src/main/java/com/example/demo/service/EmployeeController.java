package com.example.demo.service;

import com.example.demo.exception_handler.EmployeeNotFound;
import com.example.demo.models.Employee;
import com.example.demo.models.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
    EmployeeDao service;
    @GetMapping("/employees")
    public List<Employee> getAll(){
        return service.getAllEmployees();
    }
    @GetMapping("/employees/{empId}")
    public Employee getEmployeebyID(@PathVariable int empId){
       Employee employee= service.getEmployeebyId(empId);
       if(employee==null)
           throw new EmployeeNotFound("Employee not found");
       return employee;
    }

    @PostMapping("employees/user")
    public void saveEmployee(@RequestBody Employee emp){
        service.saveEmployee(emp);
    }
}
