package com.techzen.academy_n1224.employees.service;

import com.techzen.academy_n1224.employees.model.Department;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IDepartmentService {

    public Page<Department> getAll(Pageable pageable);

    public Department findById(int id);

    public Department save(Department department);

    public Department delete(int id);
}
