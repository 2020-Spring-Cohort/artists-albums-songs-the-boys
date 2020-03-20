package org.wcci.apimastery.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
@Entity

public class Comment {
    @Id
    @GeneratedValue
    private long id;

    public long getId() {
        return id;
    }

    private String text;
    @ManyToOne
    private Artist artist;
    @ManyToOne
    private Album album;
    @ManyToOne
    private Song song;


    public String getText() {
        return text;
    }

    public Comment(String text,Artist artist, Album album, Song song) {
        this.artist= artist;
        this.album= album;
        this.song = song;
        this.text = text;
    }
    public Comment() {

    }

    public Artist getArtist() {
        return artist;
    }

    public Album getAlbum() {
        return album;
    }

    public Song getSong() {
        return song;
    }
}


