package com.example.gradle.service;

import com.example.gradle.Customer;
import com.example.gradle.repository.CustomerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import reactor.core.scheduler.Scheduler;

import javax.annotation.PostConstruct;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
@Slf4j
public class CustomerService {

    private final CustomerRepository customerRepository;

    private Scheduler scheduler;
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public CustomerService(CustomerRepository customerRepository, Scheduler scheduler, JdbcTemplate jdbcTemplate) {
        this.customerRepository = customerRepository;
        this.scheduler = scheduler;
        this.jdbcTemplate = jdbcTemplate;
    }

    private static void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.printf("%dm %d s passed%n", i / 60, i % 60);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static List<Customer> extractData(ResultSet rs) {
        List<Customer> customers = new ArrayList<>();
        try {

            while (rs.next()) {
                customers.add(new Customer(rs.getString("customer_name"),
                        rs.getString("contact_name"), rs.getString("address"), rs.getString("city"), rs.getString("postal_code"), rs.getString("country")));
            }
        } catch (SQLException e) {
            log.error("Error while extracting result set:", e);
        }
        return customers;
    }

    @PostConstruct
    public void init() {
        scheduler.schedule(CustomerService::run, 20, TimeUnit.SECONDS);
        System.out.println("Waiting for scheduler to start its task");
    }

    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    public List<Customer> selectFirstThreeCustomers() {
        return jdbcTemplate.query("SELECT * FROM mydb.public.top_3_customers", CustomerService::extractData);
    }
}