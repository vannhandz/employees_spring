package com.techzen.academy_n1224.employees.dto.employee;

import com.techzen.academy_n1224.employees.dto.department.DepartmentRequest;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;


import java.time.LocalDate;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)

public class EmployeeRequest {

    String name;
    LocalDate birth;
    String gender;
    Double salary;
    String phone;
    DepartmentRequest idDepartment;

}
