package com.example.cupcakeBackend.model;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name = "frosting")
public class Frosting {




    @Id
    @GeneratedValue
    @Column(name = "frosting_id")
    private long id;


    @Column(name = "frosting_name")
    private String frostingName;

    @Column(name = "price")
    private int price;

    @Column(name = "imageURL")
    private String imageURL;




    public Frosting() {
        super();
    }

    public Frosting(String frostingName) {
        super();
        this.frostingName = frostingName;
        this.price = price;
        this.imageURL = imageURL;

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public String getFrostingName() {
        return frostingName;
    }

    public void setFrostingName(String frostingName) {
        this.frostingName = frostingName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getImageURL(){ return imageURL;}

    public void setImageURL(String imageURL){this.imageURL = imageURL;}


}
