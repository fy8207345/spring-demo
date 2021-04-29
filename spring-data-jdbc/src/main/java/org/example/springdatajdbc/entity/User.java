package org.example.springdatajdbc.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.MappedCollection;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Data
public class User {

    @Id
    private Long id;
    private String userName;
    private String password;
    private Date createdTime;
    private Date updatedTime;

    /**
     * USER_ID在ContactAddress表中，但是不能出现在实体声明中
     */
    @MappedCollection(idColumn = "USER_ID")
    private Set<ContactAddress> address;

    /**
     * ID在Contact表中，隐射到本表的id列，但是不能出现在实体声明中
     * CONTACT_NO在Contact表中，隐射到Contact表
     */
    @MappedCollection(idColumn = "ID", keyColumn = "CONTACT_NO")
    private List<Contact> contacts;

    /**
     * ID在Contact表中，隐射到本表的id列，但是不能出现在实体声明中
     * CONTACT_TYPE在Contact表中
     */
    @MappedCollection(idColumn = "ID", keyColumn = "CONTACT_TYPE")
    private Map<ContactType, Contact> contactMap;

    private UserType userType;
}
