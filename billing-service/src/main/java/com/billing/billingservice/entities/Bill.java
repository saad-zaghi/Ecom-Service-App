package com.billing.billingservice.entities;

import com.billing.billingservice.enums.BillStatus;
import com.billing.billingservice.models.Customer;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date billingDate;
    private BillStatus status;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy = "bill")
    private Collection<ProductItem> productItems;
    private Long customerID;
    @Transient
    private Customer customer;

}
