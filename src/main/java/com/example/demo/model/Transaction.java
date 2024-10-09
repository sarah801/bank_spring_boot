package com.example.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Builder
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {
     @Id
     @SequenceGenerator(
             name = "account_ID_Sequence" ,
             sequenceName = " account_ID_Sequence"
     )
     @GeneratedValue(
             strategy = GenerationType.SEQUENCE ,
             generator = "account_ID_Sequence"
     )

     private int transactionId ;
     @Column(nullable = false)
     private String transactionType ;
     @Column(nullable = false)
     private  double amount ;
     @CreationTimestamp
     private Date timestamp  ;
     @JoinColumn
     @ManyToOne
     private Account sourceAccount ;
     @JoinColumn
     @ManyToOne
     private Account targetAccount ;

}
