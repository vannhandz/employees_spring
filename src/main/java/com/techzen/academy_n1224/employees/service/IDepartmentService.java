package com.techzen.academy_n1224.employees.service;

import com.techzen.academy_n1224.employees.model.Department;
import com.techzen.academy_n1224.employees.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IDepartmentService {

    public Page<?> getAll(Pageable pageable);

    public Department findById(int id);

    public Department save(Department department);

    public void delete(int id);
}
