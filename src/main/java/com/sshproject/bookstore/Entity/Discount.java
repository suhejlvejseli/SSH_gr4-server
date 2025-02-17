package com.sshproject.bookstore.Entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@Table(name="discount")
public class Discount {

    public Discount(String discount_code, double discount_percentage, LocalDate expire_date){
        this.discountCode = discount_code;
        this.discount_percentage = discount_percentage;
        this.expire_date = expire_date;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String discountCode;

    private double discount_percentage;

    private LocalDate expire_date;
}
