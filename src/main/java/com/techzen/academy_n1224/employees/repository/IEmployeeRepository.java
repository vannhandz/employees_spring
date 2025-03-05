package com.techzen.academy_n1224.employees.repository;

import com.techzen.academy_n1224.employees.dto.EmployeeSearchRequest;
import com.techzen.academy_n1224.employees.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IEmployeeRepository extends JpaRepository<Employee, Integer> {

    @Query("FROM Employee")
    public List<?> getALl(Employee employee);

    public Employee findById(int id);

    public Employee save(Employee employee);


}
