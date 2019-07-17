package com.tw.apistackbase.controller;

import com.tw.apistackbase.model.Employee;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeesController {
    List<Employee> employeeList =new ArrayList<>();
    @GetMapping
    public List<Employee> getAllEmployees(){
        return Employee.createTestEmployee();
    }
    @PostMapping
    public String addEmployee( Employee employee){
        employeeList.add(employee);
        return "add employee success";
    }
    @DeleteMapping("/{id}")
    public String deleteEmployee(@PathVariable int id){
        employeeList.forEach(item->{if(item.getId()==id)employeeList.remove(item);});
        return "delete employee success";
    }

    @PutMapping("/{id}")
    public String updateEmployee(@PathVariable int id,Employee employee){
        for (Employee e:employeeList) {
            if(e.getId()==id){
                employeeList.remove(employee);
            }
        }
        employeeList.add(employee);
        return "update employee success";
    }

}
