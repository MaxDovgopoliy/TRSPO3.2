package org.example.dovhopolyi.controllers;

import org.example.dovhopolyi.dao.TourDAO;
import org.example.dovhopolyi.dao.CustomerDAO;
import org.example.dovhopolyi.model.Tour;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.ServletException;
import java.io.IOException;

@RestController
@RequestMapping("/admin")
public class AdminController {
    private final TourDAO tourDAO;
    private final CustomerDAO customerDAO;
    @Autowired
    public AdminController(TourDAO tourDAO, CustomerDAO customerDAO) {
        this.tourDAO = tourDAO;
        this.customerDAO = customerDAO;
    }

    @PatchMapping("/{id}/sale")
    public @ResponseBody void makeHot(@PathVariable("id") int tourId) {
        tourDAO.makeTourHot(tourId);
    }
    @GetMapping("/show/customers")
    public @ResponseBody RedirectView showCustomers() {
        return new RedirectView("/customers");
    }
    @PatchMapping("/{id}/discount")
    public @ResponseBody void SetDiscount(@PathVariable("id") int customerId,@RequestParam int discount) {
        customerDAO.setDiscountToCustomer(discount,customerId);
    }

    @RequestMapping (method = RequestMethod.POST,value = "/add")
    public RedirectView add(@ModelAttribute Tour tour, Model model) throws ServletException, IOException {

        tourDAO.saveTour(tour);
        return new RedirectView("/tours");
    }
    @DeleteMapping("/{id}")
    public RedirectView delete(@PathVariable("id") int id) {
        tourDAO.removeTour(id);
        return new RedirectView("/tours");
    }
}
