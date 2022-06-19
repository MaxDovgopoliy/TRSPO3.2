package org.example.dovhopolyi.dao;

import org.example.dovhopolyi.model.Tour;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TourDAO {
    private static int TOUR_ID;
    private List<Tour> tours=new ArrayList<>();



    public List<Tour> getAllTours() {
        return tours;
    }
    public Tour getTour(int id) {
        return tours.stream().filter(tour -> tour.getId()==id).findAny().orElse(null);
    }
    public void removeTour(int id){
tours.removeIf(tour -> tour.getId()==id);
    }
    public void saveTour (Tour tour){
        tour.setId(++TOUR_ID);
        tours.add(tour);
    }
    public void makeTourHot(int id){
        Tour tour =tours.stream().filter(t -> t.getId()==id).findAny().orElse(null);
        if(tour!=null)tour.setHot(true);

    }
}
