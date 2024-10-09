package com.example.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "bank_user")
public class User {
    @Id
    @SequenceGenerator(
            name = "account_ID_Sequence" ,
            sequenceName = " account_ID_Sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE ,
            generator = "account_ID_Sequence"
    )
    private long userId;
    @Column(nullable = false)
    private String name;
    private String address;
    private String phoneNumber;
    @Column(nullable = false)
    private String email;
    @ManyToOne
    private Branch branch ;


}
