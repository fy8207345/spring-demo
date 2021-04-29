package org.example.springdatajdbc;

import lombok.extern.slf4j.Slf4j;
import org.example.springdatajdbc.entity.*;
import org.example.springdatajdbc.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.boot.test.autoconfigure.jdbc.TestDatabaseAutoConfiguration;
import org.springframework.test.annotation.Rollback;
import org.springframework.util.Assert;

import java.util.*;

@Slf4j
@DataJdbcTest(excludeAutoConfiguration = {TestDatabaseAutoConfiguration.class})
public class UserRepositoryTests {

    @Autowired
    private UserRepository userRepository;

    @Test
    @Rollback(value = false)
    void insert() {
        User user = new User();
        user.setUserName("mike");
        user.setPassword("password");
        user.setCreatedTime(new Date());
        user.setUserType(UserType.EMPLOYEE);
        user.setAddress(getAddressList());
        // Creating contacts List
        List<Contact> contactList = new ArrayList<>();
        contactList.add(new Contact("(817) 569-8221"));
        contactList.add(new Contact("(817) 569-8281"));
        // Setting contacts to User
        user.setContacts(contactList);

        Map<ContactType, Contact> contactsMap = new HashMap<>();
        contactsMap.put(ContactType.OFFICE, new Contact("(817) 569-8221"));
        contactsMap.put(ContactType.MOBILE, new Contact("(817) 569-8281"));
        user.setContactMap(contactsMap);

        User createdUser = userRepository.save(user);
        System.err.println(createdUser);
        Assert.isTrue(createdUser != null, "error");
    }

    @Test
    void findAll() {
        Iterable<User> all = userRepository.findAll();
        log.info("findUsers: {}", all);
    }

    public Set<ContactAddress> getAddressList() {
        Set<ContactAddress> adresses = new HashSet<ContactAddress>();
        // Setting Contact Address1
        ContactAddress address = new ContactAddress();
        address.setStreet("Clock Tower, Mahbub College Campus");
        address.setCity("Secunderabad");
        address.setState("Andhrapradesh");
        address.setAreaCode("500003");
        address.setAddressType(AddressType.PERMANENT);
        // Setting Contact Address2
        ContactAddress currentAddress = new ContactAddress();
        currentAddress.setStreet("FN 501, Vamseekuteer");
        currentAddress.setCity("Secunderabad");
        currentAddress.setState("Andhrapradesh");
        currentAddress.setAreaCode("500003");
        currentAddress.setAddressType(AddressType.RESIDENCE);
        adresses.add(address);
        adresses.add(currentAddress);
        return adresses;
    }
}
