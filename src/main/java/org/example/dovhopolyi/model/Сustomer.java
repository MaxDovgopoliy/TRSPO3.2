package org.example.dovhopolyi.model;

import java.util.ArrayList;
import java.util.List;

public class Сustomer {


    private int id;
    private String name;
    private String surname;
    private int discount;
    private List<Tour>boughtTours=new ArrayList<>();

    public List<Tour> getBoughtTours() {
        return boughtTours;
    }

    public void setBoughtTours(List<Tour> boughtTours) {
        this.boughtTours = boughtTours;
    }

    public void addTour(Tour tour){
        boughtTours.add(tour);
    }

    public Сustomer() {
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public Сustomer(int id,String name, String surname, int discount) {
        this.name = name;
        this.surname = surname;
        this.discount = discount;
    }

    @Override
    public String toString() {
        return "Сustomer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", discount=" + discount +
                ", boughtTours=" + boughtTours +
                '}';
    }
}
