package org.example.dovhopolyi.dao;

import org.example.dovhopolyi.model.Tour;
import org.example.dovhopolyi.repositoriy.TourRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class TourDAO {
    private static int TOUR_ID;
    @Autowired
    TourRepository tours;


    public List<Tour> getAllTours() {
        return tours.findAll();
    }

    public Tour getTour(int id) {
        return tours.findAll().stream().filter(tour -> tour.getId() == id).findAny().orElse(null);
    }

    public void removeTour(int id) {
        Optional<Tour> tourOp = tours.findAll().stream().filter(tour -> tour.getId() == id).findAny();
        if (tourOp.isPresent()) {
            tours.deleteById(id);
        }
    }

    public void saveTour(Tour tour) {
        tours.save(tour);
    }

    public void makeTourHot(int id) {
        Tour tour = tours.findAll().stream().filter(t -> t.getId() == id).findAny().orElse(null);
        if (tour != null) {
            tour.setHot(true);
            tours.save(tour);
        }
    }
}
