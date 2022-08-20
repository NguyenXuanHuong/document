package com.example.testHttpServletRequest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cars {

    @Id
    @SequenceGenerator(
            name = "person_sequence",
            sequenceName = "person_sequence_table"
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "car_id")
    private Long id;

    private String carName;

    @ManyToOne
    private Person person;

    @OneToMany(mappedBy = "car")
    private List<Wheel> listWheel = new ArrayList<>();
}
