package org.example.dovhopolyi.controllers;

import org.example.dovhopolyi.dao.TourDAO;
import org.example.dovhopolyi.model.Tour;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tours")
public class TourController {
    private final TourDAO tourDAO;
    @Autowired
    public TourController(TourDAO tourDAO) {
        this.tourDAO = tourDAO;
    }

    @GetMapping()
    public @ResponseBody String index() {
        StringBuilder stringBuilder= new StringBuilder();
        for(Tour tour:tourDAO.getAllTours()){
            stringBuilder.append(tour);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }


}
