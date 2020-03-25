package org.wcci.apimastery.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;


@Entity
public class Album {

        private String name;
        private String imagePath;
        @Id
        @GeneratedValue
        private Long id;

        @JsonIgnore
        @ManyToOne
        private Artist artist;
        @OneToMany (mappedBy = "album")
        private Collection<Song>songs;

        @ElementCollection
        private Collection<Integer>ratings;

        @ElementCollection
        private Collection<String> comments;


        public Album(String name, Artist artist, String imagePath){
                this.name = name;
                this.artist = artist;
                this.imagePath = imagePath;
        }

        public Album(String name, Artist artist, Collection<Song> songs) {
                this.name = name;
                this.artist = artist;
                this.songs = songs;
        }

        protected Album(){
        }


        public String getName() {
                return name;
        }

        public String getImagePath(){
                return imagePath;
        }

        public Long getId() {
                return id;
        }

        public Artist getArtist() {
                return artist;
        }

        public Collection<Song> getSongs() {
                return songs;
        }

        @Override
        public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                Album album = (Album) o;
                return Objects.equals(name, album.name) &&
                        Objects.equals(id, album.id) &&
                        Objects.equals(artist, album.artist);
        }

        @Override
        public int hashCode() {
                return Objects.hash(name, id, artist);
        }

        @Override
        public String toString() {
                return "Album{" +
                        "name='" + name + '\'' +
                        ", id=" + id +
                        ", artist=" + artist +
                        '}';
        }

        public void addComment(String commentToAdd){
                comments.add(commentToAdd);
        }

        public Collection<String> getComments() {
                return comments;
        }

        public Collection<Integer> getRatings() {
                return ratings;
        }
}
