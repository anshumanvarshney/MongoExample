package com.example.mongoExample.controller;

import com.example.mongoExample.dto.EmployeeDTO;
import com.example.mongoExample.entity.Employee;
import com.example.mongoExample.services.EmployeeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @RequestMapping(method = RequestMethod.GET, value = "/getAll")
    public ResponseEntity<?> getAll() {
        return new ResponseEntity<>(employeeService.findAll(), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET,value = "/getById/{Id}")
    public ResponseEntity<?>getOne(@PathVariable("Id") String Id){
        return new ResponseEntity<>(employeeService.findOne(Id),HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST,value = "/save")
    public ResponseEntity<?>save(@RequestBody EmployeeDTO employeeDTO){
        // we can't be able to return direct DTO
        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeDTO, employee);
        Employee employeeCreated = employeeService.save(employee);
        return new ResponseEntity<String>(employeeCreated.getpName()+"  "+"Added",HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET,value = "/count")
    public ResponseEntity<?>count(){
        return new ResponseEntity<>(employeeService.count(),HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET,value = "isExist/{Id}")
    public ResponseEntity<?>isExist(@PathVariable("Id")String Id){
        return new ResponseEntity<Boolean>(employeeService.exists(Id),HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.DELETE,value = "/deleteById/{Id}")
    public ResponseEntity<?>delete(@PathVariable("Id")String Id){
        employeeService.delete(Id);
        return new ResponseEntity<String>("deleted",HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.DELETE,value = "/deleteAll")
    public ResponseEntity<?>deleteAll(){
        employeeService.deleteAll();
        return new ResponseEntity<String>("All Deleted",HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST,value = "/insert")
    public ResponseEntity<?>insert(@RequestBody EmployeeDTO employeeDTO){
        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeDTO,employee);
        Employee employeeInserted = employeeService.insert(employee);
        return new ResponseEntity<>(employeeInserted.getpName()+"inserted",HttpStatus.OK);
    }
}


