package com.example.TestSQLQuery.MappingObject;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JpqlMappingDto {
    private String ename;
    private LocalDate dob;

}
