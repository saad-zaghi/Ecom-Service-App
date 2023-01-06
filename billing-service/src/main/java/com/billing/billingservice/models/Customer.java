package com.billing.billingservice.models;

import com.billing.billingservice.enums.Gender;
import lombok.Data;

@Data
public class Customer {
    private Long id;
    private String firstName;
    private String lastName;
    private String address;
    private String email;
    private String phoneNumber;
    private Gender gender;
}
