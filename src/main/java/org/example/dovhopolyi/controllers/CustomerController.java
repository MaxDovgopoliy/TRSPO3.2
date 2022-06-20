package org.example.dovhopolyi.controllers;

import org.example.dovhopolyi.dao.TourDAO;
import org.example.dovhopolyi.dao.CustomerDAO;
import org.example.dovhopolyi.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.ServletException;
import java.io.IOException;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    private final TourDAO tourDAO;
    private final CustomerDAO customerDAO;

    @Autowired
    public CustomerController(TourDAO tourDAO, CustomerDAO customerDAO) {
        this.tourDAO = tourDAO;
        this.customerDAO=customerDAO;
    }

    @GetMapping()
    public @ResponseBody String index() {
        StringBuilder stringBuilder= new StringBuilder();
        for(Customer customer:customerDAO.getAllCustomers()){
            stringBuilder.append(customer);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    @GetMapping("/show/tours")
    public @ResponseBody RedirectView showTours() {
        return new RedirectView("/tours");
    }


    @GetMapping("/{id}/buy")
    public @ResponseBody void buyTour(@PathVariable("id") int customerId,int id) {

        customerDAO.setTourToCustomer(customerId,tourDAO.getTour(id));
        tourDAO.removeTour(id);
    }

    @RequestMapping (method = RequestMethod.POST,value = "/add")
    public void add(@ModelAttribute Customer customer, Model model) throws ServletException, IOException {
        customerDAO.saveCustomer(customer);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") int id) {
        customerDAO.removeCustomer(id);
    }
}
