package com.techzen.academy_n1224.employees.service.impl;

import com.techzen.academy_n1224.employees.dto.EmployeeSearchRequest;
import com.techzen.academy_n1224.employees.model.Employee;
import com.techzen.academy_n1224.employees.repository.IEmployeeRepository;
import com.techzen.academy_n1224.employees.service.IEmployeeService;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Getter
@Setter
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Service
public class EmployeeService implements IEmployeeService {

    IEmployeeRepository employeeRepository;

    public   Page<Employee> findByAttributes(EmployeeSearchRequest employeeSearchRequest, Pageable pageable) {
        return employeeRepository.findByAttributes(employeeSearchRequest.getName(),
                    employeeSearchRequest.getDobFrom(), employeeSearchRequest.getDobTo(),
                    employeeSearchRequest.getGender() , employeeSearchRequest.getSalaryRange(),
                    employeeSearchRequest.getPhone(), employeeSearchRequest.getDepartmentId(),pageable);
    }

    public Employee findById(int id) {
        return employeeRepository.findById(id);
    }

    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    public void delete(int id) {
        employeeRepository.deleteById(id);
    }


}
