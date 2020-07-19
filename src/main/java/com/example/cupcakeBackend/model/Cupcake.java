package com.example.cupcakeBackend.model;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name = "cupcake")
public class Cupcake {




    @Id
    @GeneratedValue
    @Column(name = "id")
    private long id;


    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private int price;

    @Column(name = "imageURL")
    private String imageURL;




    public Cupcake() {
        super();
    }

    public Cupcake(String cupcakeName) {
        super();
        this.name = name;
        this.price = price;
        this.imageURL = imageURL;

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public String getImageURL(){
        return imageURL;
    }

    public void setImageURL(String imageURL){
        this.imageURL = imageURL;
    }


}
