package org.wcci.apimastery;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class Album {

        private String name;
        @Id
        @GeneratedValue
        private Long id;
        @ManyToOne
        private Artist artist;

        protected Album(){
        }
        public Album(String name, Artist artist){
            this.name = name;
            this.artist = artist;
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

}
