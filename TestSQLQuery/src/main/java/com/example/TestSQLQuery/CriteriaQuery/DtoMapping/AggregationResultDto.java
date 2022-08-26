package com.example.TestSQLQuery.CriteriaQuery.DtoMapping;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AggregationResultDto {
    private Long max;
    private Long count;
    private Long countDistinct;
    private Long sum;
    private Double avg;
}
