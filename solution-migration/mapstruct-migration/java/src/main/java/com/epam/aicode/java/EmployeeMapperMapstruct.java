package com.epam.aicode.java;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EmployeeMapperMapstruct {

    EmployeeMapperMapstruct INSTANCE = Mappers.getMapper(EmployeeMapperMapstruct.class);
}
