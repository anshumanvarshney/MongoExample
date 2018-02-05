package com.example.mongoExample.services.impl;

import com.example.mongoExample.entity.Employee;
import com.example.mongoExample.repository.EmployeeRepository;
import com.example.mongoExample.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findOne(String Id) {
        return employeeRepository.findOne(Id);
    }

    @Override
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    public long count(){
        return employeeRepository.count();
    }

    @Override
    public Boolean exists(String Id) {
        return employeeRepository.exists(Id);
    }

    @Override
    public void delete(String Id){
         employeeRepository.delete(Id);
    }

    @Override
    public void deleteAll() {
         employeeRepository.deleteAll();
    }

    @Override
    public Employee insert(Employee employee) {
        return employeeRepository.insert(employee);
    }
}
