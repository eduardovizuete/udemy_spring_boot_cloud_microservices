package net.javaguides.employeeservice.service.impl;

import lombok.AllArgsConstructor;
import net.javaguides.employeeservice.dto.EmployeeDto;
import net.javaguides.employeeservice.entity.Employee;
import net.javaguides.employeeservice.exception.ResourceNotFoundException;
import net.javaguides.employeeservice.mapper.AutoEmployeeMapper;
import net.javaguides.employeeservice.repository.EmployeeRepository;
import net.javaguides.employeeservice.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;
    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
        Employee employee = AutoEmployeeMapper.MAPPER.mapToEmployee(employeeDto);

        Employee savedEmployee = employeeRepository.save(employee);

        EmployeeDto savedEmployeedDto = AutoEmployeeMapper.MAPPER.maptoEmployeeDto(savedEmployee);

        return savedEmployeedDto;
    }

    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {
        Optional<Employee> employeeById = employeeRepository.findById(employeeId);
        Employee employee = employeeById.orElseThrow(
                () -> new ResourceNotFoundException("Employee", "id", employeeId)
        );

        EmployeeDto employeeDto = AutoEmployeeMapper.MAPPER.maptoEmployeeDto(employee);

        return employeeDto;
    }

}
