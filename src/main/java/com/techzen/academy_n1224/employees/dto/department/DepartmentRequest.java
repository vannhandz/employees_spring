package com.techzen.academy_n1224.employees.dto.department;

import lombok.*;
import lombok.experimental.FieldDefaults;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder

public class DepartmentRequest {
    int id;
    String name;
}
