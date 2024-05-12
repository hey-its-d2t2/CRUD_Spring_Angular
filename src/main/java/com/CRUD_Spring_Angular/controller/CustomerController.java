package com.CRUD_Spring_Angular.controller;

import com.CRUD_Spring_Angular.entity.Customer;
import com.CRUD_Spring_Angular.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
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

    @GetMapping("/customer/{id}")
    private ResponseEntity<Customer> getCustomerById(@PathVariable Long id){
        Customer customerById = customerService.getCustomerById(id);
        if(customerById == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(customerById);
    }

    @PutMapping("/updateCustomer/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable Long id,@RequestBody Customer customer){
        Customer existingCustomer = customerService.getCustomerById(id);
        if(existingCustomer == null){
            return ResponseEntity.notFound().build();
        }
        existingCustomer.setName(customer.getName());
        existingCustomer.setEmail(customer.getEmail());
        existingCustomer.setPhone(customer.getPhone());
        Customer updateeCus = customerService.updateCustomer(existingCustomer);
        return ResponseEntity.ok(updateeCus);
    }

    @DeleteMapping("/deleteCustoemr/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable Long id){
        Customer customerById = customerService.getCustomerById(id);
        if(customerById == null){
            return ResponseEntity.notFound().build();
        }
        customerService.deleteCustomer(id);
        return ResponseEntity.ok().build();
    }
}
