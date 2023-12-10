package ma.piko.customerfrontthymeleafap;

import ma.piko.customerfrontthymeleafap.entities.Customer;
import ma.piko.customerfrontthymeleafap.repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ma.piko.customerfrontthymeleafap.repositories.CustomerRepository;

@SpringBootApplication
public class CustomerFrontThymeleafApApplication {

    public static void main(String[] args) {

        SpringApplication.run(CustomerFrontThymeleafApApplication.class);
    }


        @Bean
        CommandLineRunner commandLineRunner(CustomerRepository customerRepository){

        return args -> {

            customerRepository.save(new Customer(null,"HAMZA BRAIMI","hamza.Braimi33@gmail.com"));
            customerRepository.save(new Customer(null,"Hakim BRcs","hadsa.Braimi33@gmail.com"));
            customerRepository.save(new Customer(null,"Hamid BdsIMI","hssddmza.Braimi33@gmail.com"));




        };


        }






}
