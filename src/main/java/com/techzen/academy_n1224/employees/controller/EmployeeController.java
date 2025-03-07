package com.techzen.academy_n1224.employees.controller;
import com.techzen.academy_n1224.employees.dto.EmployeeSearchRequest;
import com.techzen.academy_n1224.employees.dto.page.PageResponse;
import com.techzen.academy_n1224.employees.en.ApiException;
import com.techzen.academy_n1224.employees.en.ErrorCode;
import com.techzen.academy_n1224.employees.en.JsonResponse;
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

    @GetMapping()
    public ResponseEntity<?> finAttribute(EmployeeSearchRequest employeeSearchRequest, Pageable pageable) throws ApiException {
        return JsonResponse.ok(new PageResponse<>(employeeService.findByAttributes(employeeSearchRequest,pageable)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getEmployees(@PathVariable("id") int id) {
        if(employeeService.findById(id) == null) {
            throw new ApiException(ErrorCode.Employees_NOT_EXIST);
        }
        return JsonResponse.ok(employeeService.findById(id));
    }

    @PostMapping()
    public ResponseEntity<?> addEmployees(@RequestBody Employee employee) {
       return JsonResponse.created(employeeService.save(employee));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updEmployees(@RequestBody Employee employee,
                                          @PathVariable("id") int id) {
        if(employeeService.findById(id) == null) {
            throw new ApiException(ErrorCode.Employees_NOT_EXIST);
        }
        employee.setId(id);
        return JsonResponse.ok(employeeService.save(employee));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteEmployees(@PathVariable("id") int id) {
        if(employeeService.findById(id) == null) {
            throw new ApiException(ErrorCode.Employees_NOT_EXIST);
        }
        employeeService.delete(id);
        return JsonResponse.noContent();
    }

}
