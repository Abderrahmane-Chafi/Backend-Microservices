package org.sid.customerservice;

import org.sid.customerservice.config.CustomerConfigParams;
import org.sid.customerservice.entities.Customer;
import org.sid.customerservice.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import java.util.List;

@SpringBootApplication
@EnableConfigurationProperties(CustomerConfigParams.class)
public class CustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(CustomerRepository customerRepository,
                                               RepositoryRestConfiguration restConfiguration){
        return args -> {
            restConfiguration.exposeIdsFor(Customer.class); //By default, Spring Data REST hides the primary key (id) of entities in the JSON responses for security and abstraction purposes. this code expose it.
            customerRepository.saveAll(
                    List.of(
                            Customer.builder().name("Chafi").email("chafi@gmail.com").build(),
                            Customer.builder().name("Mohamed").email("mohamed@gmail.com").build(),
                            Customer.builder().name("Younes").email("younes@gmail.com").build()
                    )
            );
            customerRepository.findAll().forEach(c ->{
                System.out.println(c);
            } );
        };
    }

}
