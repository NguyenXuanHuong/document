package com.example.TestSQLQuery.CriteriaQuery.DtoMapping;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResultDtoMapping {

    private Long id;
    private String eName;
    private LocalDate dob;
}
