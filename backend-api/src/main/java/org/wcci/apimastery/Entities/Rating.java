package org.wcci.apimastery.Entities;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity

public class Rating {
    @Id
    @GeneratedValue
    private long id;

    public long getId() {
        return id;
    }


    @ManyToOne
    private Artist artist;
    @ManyToOne
    private Album album;
    @ManyToOne
    private Song song;

    private int score;

    public int getScore() {
        return score;
    }

    public Rating(int score,Artist artist, Album album, Song song) {
        this.artist=artist;
        this.album=album;
        this.song=song;
        this.score = score;

    }

    public Rating () {

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
