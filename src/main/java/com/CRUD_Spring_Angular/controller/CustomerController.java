package com.CRUD_Spring_Angular.controller;

import com.CRUD_Spring_Angular.entity.Customer;
import com.CRUD_Spring_Angular.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/AngSpring")
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService customerService;

    @PostMapping("/customer")
    public Customer postCustomer(@RequestBody Customer customer) {
        return customerService.postCustomer(customer);
    }

    @GetMapping("/allcustomer")
    private List<Customer> getAllCustomer(){
        return customerService.getAllCustomer();
    }

}
