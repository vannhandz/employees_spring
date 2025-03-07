package com.techzen.academy_n1224.employees.repository;

import com.techzen.academy_n1224.employees.model.Department;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import java.util.List;

public interface IDepartmentRepository extends JpaRepository<Department, Integer> {

//    @Query("FROM Department ")
    public Page<Department> findAll(Pageable pageable);

    public Department findById(int id);

    public Department save(Department department);


}
