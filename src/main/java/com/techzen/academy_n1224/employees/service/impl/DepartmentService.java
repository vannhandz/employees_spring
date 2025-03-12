package com.techzen.academy_n1224.employees.service.impl;


import com.techzen.academy_n1224.employees.model.Department;
import com.techzen.academy_n1224.employees.repository.IDepartmentRepository;
import com.techzen.academy_n1224.employees.service.IDepartmentService;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Getter
@Setter
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Service
public class DepartmentService implements IDepartmentService {

    IDepartmentRepository departmentRepository;

    public Page<Department> getAll(Pageable pageable) {
        return departmentRepository.findAll(pageable);
    }

    public Department findById(int id) {
        return departmentRepository.findById(id);
    }

    public Department save(Department department) {
        return departmentRepository.save(department);
    }

    public Department delete(int id) {
        departmentRepository.deleteById(id);
        return null;
    }

}
