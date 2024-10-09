package com.example.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Account {
    @Id
    @SequenceGenerator(
            name = "account_ID_Sequence" ,
            sequenceName = " account_ID_Sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE ,
            generator = "account_ID_Sequence"
    )
    private int accountId ;
    @Column(nullable = false)
    private long accountNumber ;
    private double  balance ;
    @Column(nullable = false)
    private String accountType ;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private  User user ;

}
