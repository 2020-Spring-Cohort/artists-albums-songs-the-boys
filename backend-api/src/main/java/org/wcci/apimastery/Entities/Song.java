package org.wcci.apimastery.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Collection;

@Entity

public class Song {
    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String duration;

    @JsonIgnore
    @ManyToOne
    private Album album;

    @OneToMany (mappedBy = "song")
    private Collection<Rating>ratings;

    protected Song(){}

    public Song(String title, String duration, Album album) {
        this.title=title;
        this.duration=duration;
        this.album=album;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDuration(){
        return duration;
    }

    public Album getAlbum() {
        return album;
    }


//    public Collection<Comment> getComments() {
//        return comments;
//    }

    public Collection<Rating> getRatings() {
        return ratings;
    }
}









