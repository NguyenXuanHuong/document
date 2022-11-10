package com.example.TestSQLQuery.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class EmployeeOneToOne {
    @Id
    @GeneratedValue(generator="wallet_transaction_uuid")
    @GenericGenerator(name="wallet_transaction_uuid", strategy = "uuid2")
    private String id;

    private String oneToOneName;
}
