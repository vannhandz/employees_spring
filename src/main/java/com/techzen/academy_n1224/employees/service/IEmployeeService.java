package com.techzen.academy_n1224.employees.service;

import com.techzen.academy_n1224.employees.dto.EmployeeSearchRequest;
import com.techzen.academy_n1224.employees.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IEmployeeService {

    public   Page<Employee> findByAttributes(EmployeeSearchRequest employeeSearchRequest, Pageable pageable);

    public Employee findById(int id);

    public Employee save(Employee employee);

    public Employee delete(int id);


}
