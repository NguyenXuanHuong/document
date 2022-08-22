package com.example.AmigoMongoSpringBoot;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {

    private String country;
    private String postcode;
    private String city;

}
