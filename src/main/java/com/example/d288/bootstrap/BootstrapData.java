package com.example.d288.bootstrap;

import com.example.d288.dao.CustomerRepository;
import com.example.d288.dao.DivisionRepository;
import com.example.d288.entities.Customer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class BootstrapData implements CommandLineRunner {

    private final CustomerRepository customerRepository;
    private final DivisionRepository divisionRepository;

    public BootstrapData(CustomerRepository customerRepository, DivisionRepository divisionRepository){
        this.customerRepository = customerRepository;
        this.divisionRepository = divisionRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if(customerRepository.count() == 1) {
            Customer customer1 = new Customer();
            customer1.setFirstName("John");
            customer1.setLastName("Johnson");
            customer1.setPostal_code("12345");
            customer1.setAddress("652 Easy Street");
            customer1.setPhone("(505)632-1818");
            customer1.setDivision(divisionRepository.findAll().get(7));
            customer1.setCreate_date(new Date());
            customer1.setLast_update(new Date());

            Customer customer2 = new Customer();
            customer2.setFirstName("John");
            customer2.setLastName("Smith");
            customer2.setPostal_code("12445");
            customer2.setAddress("789 Easy Street");
            customer2.setPhone("(505)632-1800");
            customer2.setDivision(divisionRepository.findAll().get(7));
            customer2.setCreate_date(new Date());
            customer2.setLast_update(new Date());

            Customer customer3 = new Customer();
            customer3.setFirstName("Jane");
            customer3.setLastName("Johnson");
            customer3.setPostal_code("12645");
            customer3.setAddress("121 Easy Street");
            customer3.setPhone("(505)632-1802");
            customer3.setDivision(divisionRepository.findAll().get(7));
            customer3.setCreate_date(new Date());
            customer3.setLast_update(new Date());

            Customer customer4 = new Customer();
            customer4.setFirstName("Sara");
            customer4.setLastName("Johnson");
            customer4.setPostal_code("12300");
            customer4.setAddress("100 Easy Street");
            customer4.setPhone("(505)655-0018");
            customer4.setDivision(divisionRepository.findAll().get(7));
            customer4.setCreate_date(new Date());
            customer4.setLast_update(new Date());

            Customer customer5 = new Customer();
            customer5.setFirstName("Sam");
            customer5.setLastName("Doe");
            customer5.setPostal_code("15545");
            customer5.setAddress("500 Easy Street");
            customer5.setPhone("(505)652-9648");
            customer5.setDivision(divisionRepository.findAll().get(7));
            customer5.setCreate_date(new Date());
            customer5.setLast_update(new Date());

            customerRepository.save(customer1);
            customerRepository.save(customer2);
            customerRepository.save(customer3);
            customerRepository.save(customer4);
            customerRepository.save(customer5);

            System.out.println("Customers added!");
        } else{
            System.out.println("Customers already exist!");
        }
    }
}
