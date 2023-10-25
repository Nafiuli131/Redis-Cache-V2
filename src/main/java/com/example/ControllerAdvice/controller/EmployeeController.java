package com.example.ControllerAdvice.controller;

import com.example.ControllerAdvice.dto.EmployeeDto;
import com.example.ControllerAdvice.entity.Employee;
import com.example.ControllerAdvice.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @PostMapping("")
    public ResponseEntity<Employee> saveEmployee(@RequestBody EmployeeDto employeeDto){
        Employee employee = employeeService.saveEmployee(employeeDto);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    @Cacheable(key = "#id",value = "employee")
//    public ResponseEntity<Employee> findById(@PathVariable Long id){ //not possible for caching because responseentity
//        not serializable
    public Employee findById(@PathVariable Long id){
        return employeeService.getEmployeeById(id);
    }
    @GetMapping("/all")
    public List<EmployeeDto> getAllEmployees(){
        return employeeService.getAllEmployees();
    }
    @DeleteMapping("/{id}")
    @CacheEvict(value = "employee", allEntries = true)
    public ResponseEntity<?> deleteById(@PathVariable Long id){
        employeeService.deleteById(id);
        return new ResponseEntity<>("Deleted Successfully",HttpStatus.ACCEPTED);
    }

    //update employee
    @PutMapping("/{id}")
    @CachePut(value = "employee",key = "#id")
    public Employee updateEmployee(@PathVariable Long id,@RequestBody EmployeeDto employeeDto){
        return employeeService.updateEmployee(id,employeeDto);
    }
}
