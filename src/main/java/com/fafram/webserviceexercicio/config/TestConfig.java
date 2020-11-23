package com.fafram.webserviceexercicio.config;

import com.fafram.webserviceexercicio.entities.Customer;
import com.fafram.webserviceexercicio.entities.Phone;
import com.fafram.webserviceexercicio.repositories.CustomerRepository;
import com.fafram.webserviceexercicio.repositories.PhoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    // injeção de dependência
    @Autowired
    private PhoneRepository phoneRepository;

    // injeção de dependência
    @Autowired
    private CustomerRepository customerRepository;


    // database seeding
    @Override
    public void run(String... args) throws Exception {

        Phone pho1 = new Phone(null,"celular", 1156151626);
        Phone pho2 = new Phone(null,"celular", 112312316);
        Phone pho3 = new Phone(null,"celular", 115143426);

        Customer customer1 = new Customer(null,"Julia","jujuba", "51451151");
        Customer customer2 = new Customer(null,"Bruno","jujubdasd", "514513121151");
        Customer customer3 = new Customer(null,"Andreia","jujuasdaba", "514511312351");

        customerRepository.saveAll(Arrays.asList(customer1, customer2, customer3));
        phoneRepository.saveAll(Arrays.asList(pho1, pho2, pho3));

        customer1.getPhones().add(pho1);
        customer1.getPhones().add(pho2);

        customerRepository.saveAll(Arrays.asList(customer1, customer2, customer3));

    }
}
