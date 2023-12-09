package ma.piko.customerfrontthymeleafap.web;


import ma.piko.customerfrontthymeleafap.entities.Customer;
import ma.piko.customerfrontthymeleafap.repositories.CustomerRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List ;
@Controller
public class CustomerController {

    private CustomerRepository customerRepository ;


    public CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @GetMapping("/customers")

public String customers(Model model){

        List<Customer> listCustomers =customerRepository.findAll();
        model.addAttribute("customers",listCustomers);
    return "customers" ;}














}
