package com.techzen.academy_n1224.employees.mapper;

import com.techzen.academy_n1224.employees.dto.department.DepartmentRequest;
import com.techzen.academy_n1224.employees.dto.department.DepartmentResponse;
import com.techzen.academy_n1224.employees.model.Department;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IDepartmentMapper {
    Department departmentRequestToDepartment(DepartmentRequest departmentRequest);
    DepartmentResponse mapDepartmentToDepartmentResponse(Department department);

}
