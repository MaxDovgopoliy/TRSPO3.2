package org.example.dovhopolyi.dao;

import org.example.dovhopolyi.model.Tour;
import org.example.dovhopolyi.model.Сustomer;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CustomerDAO {
    private static int CUSTOMER_ID;
    private List<Сustomer> customers=new ArrayList<>();

    public void setDiscountToCustomer(int discount,int id){
        Сustomer customer= customers.stream().filter(c->c.getId()==id).findAny().orElse(null);
        if(customer!=null)customer.setDiscount(discount);
    }

    public void setTourToCustomer(int cutomerId,Tour tour){
        Сustomer customer= customers.stream().filter(cust->cust.getId()==cutomerId).findAny().orElse(null);
        customer.addTour(tour);
    }
    public void saveCustomer (Сustomer customer){
        customer.setId(++CUSTOMER_ID);
        customers.add(customer);
    }
    public List<Сustomer> getAllCustomers() {
        return customers;
    }
    public void removeCustomer(int id){
        customers.removeIf(customer -> customer.getId()==id);
    }
}
