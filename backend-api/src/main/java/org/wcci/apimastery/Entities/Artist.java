package org.wcci.apimastery.Entities;


import javax.persistence.*;
import java.util.Collection;

@Entity
public class Artist {
    private String name;

    @Id
    @GeneratedValue
    private Long id;

    @OneToMany(mappedBy = "artist")
    Collection<Album> albums;

    @ElementCollection
    private Collection<Integer>ratings;

    protected Artist() {
    }

    public Artist(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public Collection<Album> getAlbums() {
        return albums;
    }

    public String getName() {
        return name;
    }

//    public Collection<Comment> getComments() {
//        return comments;
//    }

    public Collection<Integer> getRatings() {
        return ratings;
    }
}
