package com.techzen.academy_n1224.employees.controller;

import com.techzen.academy_n1224.employees.dto.department.DepartmentRequest;
import com.techzen.academy_n1224.employees.dto.page.PageResponse;
import com.techzen.academy_n1224.employees.en.ApiException;
import com.techzen.academy_n1224.employees.en.ErrorCode;
import com.techzen.academy_n1224.employees.en.JsonResponse;
import com.techzen.academy_n1224.employees.mapper.IDepartmentMapper;
import com.techzen.academy_n1224.employees.model.Department;
import com.techzen.academy_n1224.employees.service.IDepartmentService;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RestController
@RequestMapping("/departments")
public class DepartmentController {

    IDepartmentService departmentService;
    IDepartmentMapper departmentMapper;

    @GetMapping()
    private ResponseEntity<?> getAll(Pageable pageable) {
        return JsonResponse.ok(new PageResponse<>(departmentService.getAll(pageable)
                .map(departmentMapper::mapDepartmentToDepartmentResponse)));
    }

    @GetMapping("/{id}")
    private ResponseEntity<?> getID(@PathVariable("id") int id) {
        if(departmentService.findById(id)==null){
            throw new ApiException(ErrorCode.Department_NOT_EXIST);
        }
        return JsonResponse.ok(departmentMapper.mapDepartmentToDepartmentResponse(departmentService.findById(id)));
    }

    @PostMapping()
    private ResponseEntity<?> create(@RequestBody DepartmentRequest departmentRequest) {
        Department department = departmentMapper.departmentRequestToDepartment(departmentRequest);

        return JsonResponse.created(departmentMapper.mapDepartmentToDepartmentResponse(departmentService.save(department)));
    }

    @PutMapping("/{id}")
    private ResponseEntity<?> upd(@RequestBody  DepartmentRequest departmentRequest,
                                  @PathVariable("id") int id) {
        if(departmentService.findById(id)==null){
            throw new ApiException(ErrorCode.Department_NOT_EXIST);
        }
        Department department = departmentMapper.departmentRequestToDepartment(departmentRequest);
        department.setId(id);
        return JsonResponse.ok(departmentMapper.mapDepartmentToDepartmentResponse(departmentService.save(department)));
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<?> delete(@PathVariable("id") int id) {
        if(departmentService.findById(id)==null){
            throw new ApiException(ErrorCode.Department_NOT_EXIST);
        }

        departmentMapper.mapDepartmentToDepartmentResponse(departmentService.delete(id));
        return JsonResponse.noContent();
    }
}
