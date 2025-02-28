package com.epam.aicode.java;

public class EmployeeMapper {

    public EmployeeDTO employeeToEmployeeDTO(Employee employee) {
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setId(employee.getId());
        employeeDTO.setName(employee.getName());
        employeeDTO.seteMail(employee.getEmail());
        return employeeDTO;
    }
}
