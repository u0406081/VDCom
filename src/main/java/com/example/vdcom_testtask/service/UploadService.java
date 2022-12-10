package com.example.vdcom_testtask.service;

import com.example.vdcom_testtask.model.Customer;
import com.example.vdcom_testtask.repository.CustomerRepository;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

@Service
public class UploadService {
    @Autowired
    private CustomerRepository repository;

    public void save(MultipartFile file) {
        try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(file.getInputStream(),
                Charset.forName("Cp1251")));
             CSVParser csvParser = new CSVParser(fileReader,
                         CSVFormat.EXCEL.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim())) {
             List<Customer> customerList = new ArrayList<Customer>();
             Iterable<CSVRecord> csvRecords = csvParser.getRecords();

                for (CSVRecord csvRecord : csvRecords) {
                    Customer customer = new Customer();
                    customer.setSurname(csvRecord.get("Surname"));
                    customer.setName(csvRecord.get("Name"));
                    customer.setLastname(csvRecord.get("Lastname"));
                    customerList.add(customer);
                }
            repository.saveAll(customerList);
        } catch (IOException e) {
            throw new RuntimeException("fail to store csv data: " + e.getMessage());
        }
    }
}
