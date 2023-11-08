package com.example.demo.bootstrap;

import com.example.demo.dao.CustomerRepository;
import com.example.demo.dao.DivisionRepository;
import com.example.demo.entities.Customer;
import com.example.demo.entities.Division;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {


    private final CustomerRepository customerRepository;
    private final DivisionRepository divisionRepository;

    public BootStrapData(CustomerRepository customerRepository, DivisionRepository divisionRepository) {
        this.customerRepository = customerRepository;
        this.divisionRepository = divisionRepository;
    }


    @Override
    public void run(String... args) throws Exception {


       Customer josh = new Customer();
       josh.setAddress("123 Holly Hills");
       josh.setFirstName("Josh");
       josh.setLastName("Smith");
       josh.setPhone("3165555555");
       josh.setPostal_code("63129");
       josh.setDivision(divisionRepository.getReferenceById(6l));
       customerRepository.save(josh);


       Customer janet = new Customer();
       janet.setAddress("124 Holly Hills");
       janet.setFirstName("Janet");
       janet.setLastName("Brown");
       janet.setPhone("3165555556");
       janet.setPostal_code("63128");
       janet.setDivision(divisionRepository.getReferenceById(2L));
       customerRepository.save(janet);

       Customer james = new Customer();
       james.setAddress("125 Holly Hills");
       james.setFirstName("James");
       james.setLastName("Johnson");
       james.setPhone("3165555557");
       james.setPostal_code("63127");
       james.setDivision(divisionRepository.getReferenceById(3L));
       customerRepository.save(james);


       Customer jess = new Customer();
       jess.setAddress("126 Holly Hills");
       jess.setFirstName("Jessica");
       jess.setLastName("Robinson");
       jess.setPhone("3145555556");
       jess.setPostal_code("63126");
       jess.setDivision(divisionRepository.getReferenceById(4L));
       customerRepository.save(jess);


       Customer john = new Customer();
       john.setAddress("127 Holly Hills");
       john.setFirstName("John");
       john.setLastName("Valdoiz");
       john.setPostal_code("63125");
       john.setPhone("3165555553");
       john.setDivision(divisionRepository.getReferenceById(5L));
       customerRepository.save(john);



    }
}
