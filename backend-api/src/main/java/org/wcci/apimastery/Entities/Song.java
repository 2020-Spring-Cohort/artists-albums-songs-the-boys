package org.wcci.apimastery.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.wcci.apimastery.Entities.Album;
import org.wcci.apimastery.Entities.Artist;

import javax.persistence.*;

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
}





