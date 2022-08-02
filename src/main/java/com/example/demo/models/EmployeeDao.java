package com.example.demo.models;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Iterator;
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

    public Employee getEmployeeById(int Id) {
        return list.stream().filter(emp -> emp.getEmployeeId()==Id).findAny().orElse(null);
    }


    public Employee saveEmployee(Employee emp) {
        emp.setEmployeeId(list.size()+1);
        list.add(emp);
        return emp;
    }

    public Employee deleteEmployee(int empId) {
        Employee emp= null;
        for(int i=0;i< list.size();i++) {
            if (list.get(i).getEmployeeId() == empId) {
                emp = list.get(i);
                list.remove(emp);
            }
        }
        return emp;

    }
}
