package org.wcci.apimastery.Entities;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;


@Entity
public class Album {

        private String name;
        @Id
        @GeneratedValue
        private Long id;

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
}
