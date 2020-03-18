package org.wcci.apimastery.Entities;

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

    @ManyToOne
    private Artist artist;
    @ManyToOne
    private Album album;

    protected Song(){}

    public Song(String title, String duration, Artist artist,Album album) {
        this.title=title;
        this.duration=duration;
        this.artist=artist;
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

    public Artist getArtist() {
        return artist;
    }

    public Album getAlbum() {
        return album;
    }
}





