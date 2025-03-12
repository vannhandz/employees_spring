package com.techzen.academy_n1224.employees.controller;
import com.techzen.academy_n1224.employees.dto.EmployeeSearchRequest;
import com.techzen.academy_n1224.employees.dto.employee.EmployeeRequest;
import com.techzen.academy_n1224.employees.dto.page.PageResponse;
import com.techzen.academy_n1224.employees.en.ApiException;
import com.techzen.academy_n1224.employees.en.ErrorCode;
import com.techzen.academy_n1224.employees.en.JsonResponse;
import com.techzen.academy_n1224.employees.mapper.IEmployeeMapper;
import com.techzen.academy_n1224.employees.model.Employee;
import com.techzen.academy_n1224.employees.service.IEmployeeService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/employees")
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class EmployeeController  {

    IEmployeeService employeeService;
    IEmployeeMapper employeeMapper;

    @GetMapping()
    public ResponseEntity<?> finAttribute(EmployeeSearchRequest employeeSearchRequest, Pageable pageable) throws ApiException {
        return JsonResponse.ok(new PageResponse<>(employeeService.findByAttributes(employeeSearchRequest,pageable)
                .map(employeeMapper ::employeeToEmployeeResponse )));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getEmployees(@PathVariable("id") int id) {
        if(employeeService.findById(id) == null) {
            throw new ApiException(ErrorCode.Employees_NOT_EXIST);
        }
        return JsonResponse.ok(employeeMapper.employeeToEmployeeResponse(employeeService.findById(id)));
    }

    @PostMapping()
    public ResponseEntity<?> addEmployees(@RequestBody EmployeeRequest employeeRequest) {
        Employee employee = employeeMapper.employeeRequestToEmployee(employeeRequest);
       return JsonResponse.created(employeeMapper.employeeToEmployeeResponse(employeeService.save(employee)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updEmployees(@RequestBody EmployeeRequest employeeRequest,
                                          @PathVariable("id") int id) {
        if(employeeService.findById(id) == null) {
            throw new ApiException(ErrorCode.Employees_NOT_EXIST);
        }
        Employee employee = employeeMapper.employeeRequestToEmployee(employeeRequest);
        employee.setId(id);
        return JsonResponse.ok(employeeMapper.employeeToEmployeeResponse(employeeService.save(employee)));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteEmployees(@PathVariable("id") int id) {
        if(employeeService.findById(id) == null) {
            throw new ApiException(ErrorCode.Employees_NOT_EXIST);
        }
        employeeMapper.employeeToEmployeeResponse(employeeService.delete(id));
        return JsonResponse.noContent();
    }

}
