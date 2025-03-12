package com.techzen.academy_n1224.employees.mapper;

import com.techzen.academy_n1224.employees.dto.employee.EmployeeRequest;
import com.techzen.academy_n1224.employees.dto.employee.EmployeeResponse;
import com.techzen.academy_n1224.employees.model.Employee;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IEmployeeMapper {
    Employee employeeRequestToEmployee(EmployeeRequest employeeRequest);
    EmployeeResponse employeeToEmployeeResponse(Employee employee);
}
