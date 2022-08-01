package com.example.demo.models;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class EmployeeDao {
    static List<Employee> list = new ArrayList<>();
    static{
        list.add(new Employee(1234, "Hashirama","Hashirama@gmail.com"));
        list.add(new Employee(1235, "Kakashi","Kakashi@gmail.com"));
        list.add(new Employee(1236, "Lee","Lee@gmail.com"));
    }

    public List<Employee> getAllEmployees() {
        return list;
    }

    public Employee getEmployeebyId(int Id) {
        return list.stream().filter(emp -> emp.getEmployeeId()==Id).findAny().orElse(null);
    }


    public void saveEmployee(Employee emp) {
        emp.setEmployeeId(list.size()+1);
        list.add(emp);
    }
}
