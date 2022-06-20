package org.example.dovhopolyi.dao;

import org.example.dovhopolyi.model.Tour;
import org.example.dovhopolyi.model.Customer;
import org.example.dovhopolyi.repositoriy.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CustomerDAO {
    private static int CUSTOMER_ID;

    @Autowired
    CustomerRepository customers;

    public void setDiscountToCustomer(int discount, int id) {
        Customer customer = customers.findAll().stream().filter(c -> c.getId() == id).findAny().orElse(null);
        if (customer != null) {
            customer.setDiscount(discount);
            customers.save(customer);
        }
    }

    public void setTourToCustomer(int cutomerId, Tour tour) {
        Customer customer = customers.findAll().stream().filter(cust -> cust.getId() == cutomerId).findAny().orElse(null);
        customer.addTour(tour);
        customers.save(customer);
    }

    public void saveCustomer(Customer customer) {
        customers.save(customer);
    }

    public List<Customer> getAllCustomers() {
        return customers.findAll();
    }

    public void removeCustomer(int id) {
        customers.findAll().removeIf(customer -> customer.getId() == id);
    }
}
