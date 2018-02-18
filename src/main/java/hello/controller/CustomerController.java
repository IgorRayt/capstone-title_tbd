package hello.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import hello.model.Customer;
import hello.repository.CustomerRepository;

import javax.validation.Valid;

@CrossOrigin
@Controller
@RequestMapping(path = "customer")
public class CustomerController {
    @Autowired
    private CustomerRepository customerRepository;

    @PostMapping("")
    public @ResponseBody Customer createCustomer(@Valid @RequestBody Customer customer) {
        return customerRepository.save(customer);
    }

    // allow get on /customer and /customer/all
    @GetMapping(path = {"", "/all"})
    public @ResponseBody
    Iterable<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }
}
