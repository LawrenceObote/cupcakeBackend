package com.example.cupcakeBackend.model;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name = "cake_batter_name")
public class CakeBatter {




    @Id
    @GeneratedValue
    @Column(name = "cid")
    private long id;


    @Column(name = "cakebattername")
    private String cakeBatterName;

    @Column(name = "price")
    private int price;




    public CakeBatter() {
        super();
    }

    public CakeBatter(String cakeBatterName) {
        super();
        this.cakeBatterName = cakeBatterName;

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public String getCakeBatterName() {
        return cakeBatterName;
    }

    public void setCakeBatterName(String cakeBatterName) {
        this.cakeBatterName = cakeBatterName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }


}
