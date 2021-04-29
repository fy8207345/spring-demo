package org.example.springdatajdbc.entity;

import lombok.Data;
import org.springframework.data.relational.core.mapping.Column;

@Data
public class ContactAddress {
    private String street;
    private String state;
    private String city;
    @Column("ZIP_CODE")
    private String areaCode;
    @Column("ADDR_TYPE")
    private AddressType addressType;
}
