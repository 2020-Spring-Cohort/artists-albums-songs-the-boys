package org.wcci.apimastery;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Collection;

@Entity
public class Artist {
    @Id
    @GeneratedValue
    private Long id;
    @OneToMany(mappedBy = "artist")
    Collection<Album> albums;
    @OneToMany(mappedBy = "artist")
    private Collection<Song> songs;

    private String name;

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

    public Collection<Song> getSongs() {
        return songs;
    }
}
