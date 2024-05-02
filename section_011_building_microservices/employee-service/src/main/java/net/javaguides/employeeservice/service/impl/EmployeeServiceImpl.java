package net.javaguides.employeeservice.service.impl;

import lombok.AllArgsConstructor;
import net.javaguides.employeeservice.dto.APIResponseDto;
import net.javaguides.employeeservice.dto.DepartmentDto;
import net.javaguides.employeeservice.dto.EmployeeDto;
import net.javaguides.employeeservice.entity.Employee;
import net.javaguides.employeeservice.exception.ResourceNotFoundException;
import net.javaguides.employeeservice.mapper.AutoEmployeeMapper;
import net.javaguides.employeeservice.repository.EmployeeRepository;
import net.javaguides.employeeservice.service.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    private RestTemplate restTemplate;

    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
        Employee employee = AutoEmployeeMapper.MAPPER.mapToEmployee(employeeDto);

        Employee savedEmployee = employeeRepository.save(employee);

        EmployeeDto savedEmployeedDto = AutoEmployeeMapper.MAPPER.maptoEmployeeDto(savedEmployee);

        return savedEmployeedDto;
    }

    @Override
    public APIResponseDto getEmployeeById(Long employeeId) {
        Optional<Employee> employeeById = employeeRepository.findById(employeeId);

        Employee employee = employeeById.orElseThrow(
                () -> new ResourceNotFoundException("Employee", "id", employeeId)
        );

        ResponseEntity<DepartmentDto> responseEntity = restTemplate.getForEntity(
                "http://localhost:8080/api/departments/" + employee.getDepartmentCode(),
                DepartmentDto.class
        );

        DepartmentDto departmentDto = responseEntity.getBody();

        EmployeeDto employeeDto = AutoEmployeeMapper.MAPPER.maptoEmployeeDto(employee);

        APIResponseDto apiResponseDto = new APIResponseDto();
        apiResponseDto.setEmployee(employeeDto);
        apiResponseDto.setDepartment(departmentDto);

        return apiResponseDto;
    }

}
