package org.wcci.apimastery.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Collection;


@Entity
public class Album {

        private String name;
        @Id
        @GeneratedValue
        private Long id;

        @JsonIgnore
        @ManyToOne
        private Artist artist;
        @OneToMany (mappedBy = "album")
        private Collection<Song>songs;

        public Album(String name, Artist artist){
                this.name = name;
                this.artist = artist;
        }

        protected Album(){
        }


        public String getName() {
                return name;
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
}
