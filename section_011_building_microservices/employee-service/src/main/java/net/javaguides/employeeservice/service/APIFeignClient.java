package net.javaguides.employeeservice.service;

import net.javaguides.employeeservice.dto.DepartmentDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "DEPARTMENT-SERVICE")
public interface APIFeignClient {

    // build get department REST API
    @GetMapping("api/departments/{department-code}")
    DepartmentDto getDepartment(@PathVariable("department-code") String departmentCode);

}