package org.example.dovhopolyi.model;

public class Tour {
    enum TYPE{VACATION,EXCURSION,SHOPPING}
    private int id;
    private String name;
    private int price;

    public boolean isHot() {
        return isHot;
    }

    public void setHot(boolean hot) {
        isHot = hot;
    }

    @Override
    public String toString() {
        return "Tour{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", isHot=" + isHot +
                ", type=" + type +
                '}';
    }

    private  boolean isHot;
    private TYPE type;

    public TYPE getType() {
        return type;
    }

    public void setType(TYPE type) {
        this.type = type;
    }

    public Tour() {
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }





    public Tour(int id, String name, int price, boolean isHot,String type) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.isHot = isHot;
        this.type=TYPE.valueOf(type);
    }


}
