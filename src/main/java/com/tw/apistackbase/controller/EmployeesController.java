package com.tw.apistackbase.controller;

import com.tw.apistackbase.model.Employee;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeesController {
    List<Employee> employeeList =new ArrayList<>();
    @GetMapping("/selectAllEmployee")
    public List<Employee> getAllEmployees(){
        return Employee.createTestEmployee();
        //return employeeList;
    }
    @PostMapping("/addEmployee")
    public String addEmployee(@RequestBody Employee employee){
        employeeList.add(employee);
        return "add employee success";
    }
    @DeleteMapping("/deleteEmployee")
    public String deleteEmployee(@RequestParam int id){
        employeeList.remove(id);
        return "delete employee success";
    }

}
