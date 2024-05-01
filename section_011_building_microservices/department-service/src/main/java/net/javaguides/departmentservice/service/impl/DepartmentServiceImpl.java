package net.javaguides.departmentservice.service.impl;

import lombok.AllArgsConstructor;
import net.javaguides.departmentservice.dto.DepartmentDto;
import net.javaguides.departmentservice.entity.Department;
import net.javaguides.departmentservice.exception.ResourceNotFoundException;
import net.javaguides.departmentservice.repository.DepartmentRepository;
import net.javaguides.departmentservice.service.DepartmentService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private DepartmentRepository departmentRepository;
    private ModelMapper modelMapper;

    @Override
    public DepartmentDto saveDepartment(DepartmentDto departmentDto) {
        // convert department dto to department jpa entity
        Department department = modelMapper.map(departmentDto, Department.class);

        Department saveDepartment = departmentRepository.save(department);

        // convert department jpa entity to department
        DepartmentDto saveDepartmentDto = modelMapper.map(saveDepartment, DepartmentDto.class);

        return saveDepartmentDto;
    }

    @Override
    public DepartmentDto getDepartmentByCode(String departmentCode) {
        Optional<Department> department = Optional.
                ofNullable(departmentRepository.findByDepartmentCode(departmentCode));

        department.orElseThrow(
                () -> new ResourceNotFoundException("Deparment", "departmentCode", departmentCode)
        );

        // convert department jpa entity to department
        DepartmentDto departmentDto = modelMapper.map(department, DepartmentDto.class);

        return departmentDto;
    }

}
