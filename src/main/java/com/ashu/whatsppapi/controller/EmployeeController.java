package com.ashu.whatsppapi.controller;

import com.ashu.whatsppapi.model.Employee;
import com.ashu.whatsppapi.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @RequestMapping(value="/employees", method = RequestMethod.POST)
    public Employee createEmployees(@RequestBody Employee employee)
    {
       return employeeService.createEmployee(employee);
    }

    @RequestMapping(value="/employees", method = RequestMethod.GET)
    public List<Employee> readEmployees()
    {
        return employeeService.getEmployee();
    }
     @RequestMapping(value="/employees/{empId}", method = RequestMethod.DELETE)
    public void deleteEmployees(@PathVariable(value="empId") Long id)
    {
        employeeService.deleteEmployee(id);
    }
    @RequestMapping(value="/employees/{empId}", method = RequestMethod.PUT)
    public Employee readEmployees(@PathVariable(value="empId") Long id, @RequestBody Employee employee)
    {
        return employeeService.updateEmployee(id,employee);
    }

}
