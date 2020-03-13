package org.wcci.apimastery;


import javax.persistence.Entity;

@Entity
public class Artist {
    private String name;

    protected Artist(){

    }
    public Artist(String name){
        this.name = name;
    }



}
