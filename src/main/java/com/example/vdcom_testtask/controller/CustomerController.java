package com.example.vdcom_testtask.controller;

import com.example.vdcom_testtask.model.Customer;
import com.example.vdcom_testtask.service.CustomerService;
import com.example.vdcom_testtask.service.UploadService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class CustomerController {
    CustomerService customerService;
    UploadService uploadService;

    public CustomerController(CustomerService customerService, UploadService uploadService) {
        this.customerService = customerService;
        this.uploadService = uploadService;
    }

    @GetMapping("/updateCustomer")
    public String updateCustomer(@RequestParam long id, Model model) {
        Customer customer = customerService.getCustomerById(id);
        model.addAttribute("customer", customer);
        return "customer";
    }

    @GetMapping("/createCustomer")
    public String createCustomer(Model model) {
        model.addAttribute("customer", new Customer());
        return "customer";
    }

    @PostMapping("/updateCustomer")
    public String updateCustomer(Customer customer) {
        customerService.updateCustomer(customer);
        return "redirect:/allCustomers";
    }

    @RequestMapping("/allCustomers")
    public String allCustomers(Model model) {
        model.addAttribute("customers", customerService.getAllCustomers());
        return "index";
    }

    @GetMapping("/deleteCustomer")
    public String deleteCustomer(@RequestParam Long id) {
        customerService.deleteCustomer(id);
        return "redirect:/allCustomers";
    }

    @PostMapping(value="/upload", consumes = "multipart/form-data")
    public String uploadCSVFile(@RequestParam("file") MultipartFile file) {
        try {
            uploadService.save(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/allCustomers";
    }
}
