package com.example.demo.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Branch {
    @Id
    @SequenceGenerator(
            name = "account_ID_Sequence" ,
            sequenceName = " account_ID_Sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE ,
            generator = "account_ID_Sequence"
    )
    private long branchId;
    @Column(nullable = false)
    private String branchName;
    @Column(nullable = false)
    private String branchCode;

    private String address;
}
