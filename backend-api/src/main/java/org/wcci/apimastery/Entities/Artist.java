package org.wcci.apimastery.Entities;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Collection;

@Entity
public class Artist {
    private String name;

    @Id
    @GeneratedValue
    private Long id;

    @OneToMany(mappedBy = "artist")
    Collection<Album> albums;
    @OneToMany (mappedBy = "artist")
    private Collection<Comment>comments;
    @OneToMany (mappedBy = "artist")
    private Collection<Rating>ratings;

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

    public Collection<Comment> getComments() {
        return comments;
    }

    public Collection<Rating> getRatings() {
        return ratings;
    }
}
