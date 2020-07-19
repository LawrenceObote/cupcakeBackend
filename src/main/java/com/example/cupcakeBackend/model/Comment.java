package com.example.cupcakeBackend.model;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name = "comments")
public class Comment {




    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;


    @Column(name = "comment", length = 1500)
    private String comment;






    public Comment() {
        super();
    }

    public Comment(String comment) {
        super();

        this.comment = comment;


    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }




}
