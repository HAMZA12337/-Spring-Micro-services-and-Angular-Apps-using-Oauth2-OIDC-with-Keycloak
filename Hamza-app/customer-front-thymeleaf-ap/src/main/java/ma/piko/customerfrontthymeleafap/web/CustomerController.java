package ma.piko.customerfrontthymeleafap.web;


import ma.piko.customerfrontthymeleafap.entities.Customer;
import ma.piko.customerfrontthymeleafap.repositories.CustomerRepository;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;


@Controller
public class CustomerController {

    private CustomerRepository customerRepository ;
    private ClientRegistrationRepository clientRegistrationRepository;

    public CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
        this.clientRegistrationRepository = clientRegistrationRepository;
    }





    @GetMapping("/customers")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String customers(Model model) {
        List<Customer> customerList = customerRepository.findAll();
        model.addAttribute("customers", customerList);
        return "customers";
    }



    @GetMapping("/products")

    public String products (Model model){


        model.addAttribute("products",null);
        return "products" ;}



    @GetMapping("/auth")
    @ResponseBody
    public Authentication authentication(Authentication authentication){

    return authentication;}

    @GetMapping("/")
    public String index (){

        return "index" ;}



    @GetMapping("/notAuthorized")
    public String notAuthorized(){

        return "notAuthorized" ;}


    @GetMapping("/oauth2Login")
    public String oauth2Login(Model model) {
//        String authorizationRequestBaseUri = "oauth2/authorization";
//        Map<String, String> oauth2AuthenticationUrls = new HashMap();
//        Iterable<ClientRegistration> clientRegistrations = (Iterable<ClientRegistration>) clientRegistrationRepository;
//        clientRegistrations.forEach(registration ->{
//            oauth2AuthenticationUrls.put(registration.getClientName(),
//                    authorizationRequestBaseUri + "/" + registration.getRegistrationId());
//        });
//        model.addAttribute("urls", oauth2AuthenticationUrls);
        return "oauth2Login";
    }


}
