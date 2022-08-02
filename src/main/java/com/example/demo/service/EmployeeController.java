package com.example.demo.service;

import com.example.demo.exception_handler.EmployeeNotFound;
import com.example.demo.models.Employee;
import com.example.demo.models.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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
       Employee employee= service.getEmployeeById(empId);
       if(employee==null)
           throw new EmployeeNotFound("Employee not found");
       return employee;
    }

    @PostMapping("/employees/user")
    public ResponseEntity<Object>  saveEmployee(@RequestBody Employee emp){
        Employee employee= service.saveEmployee(emp);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{employeeId}").
                buildAndExpand(employee.getEmployeeId()).
                toUri();
        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping("employees/delete/{empId}")
    public void deleteEmployee(@PathVariable int empId){
       Employee employee= service.deleteEmployee(empId);
        if(employee==null)
            throw new EmployeeNotFound("Employee not found");
    }
}
