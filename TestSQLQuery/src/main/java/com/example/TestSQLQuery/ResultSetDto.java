package com.example.TestSQLQuery;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResultSetDto {

    private String nameResultSet;
    private LocalDate localDateResultSet;
}
