package com.example.vdcom_testtask.service;

import com.example.vdcom_testtask.model.Customer;
import com.example.vdcom_testtask.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository repository;

    public CustomerService(CustomerRepository repository) {
        this.repository = repository;
    }

    public Customer getCustomerById(Long id) {
        return repository.getOne(id);
    }

    public List<Customer> getAllCustomers() {
        return repository.findAll();
    }

    public void deleteCustomer(Long id) {
        repository.deleteById(id);
    }

    public void updateCustomer(Customer customer) {
        repository.save(customer);
    }
}
