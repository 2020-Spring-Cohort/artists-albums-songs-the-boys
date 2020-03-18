package org.wcci.apimastery.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.wcci.apimastery.Entities.Artist;
import org.wcci.apimastery.Storage.Repositories.ArtistRepository;

import java.util.Collection;

@RestController
public class ArtistController {
    private ArtistRepository artistRepository;

    public ArtistController(ArtistRepository artistRepository){
        this.artistRepository = artistRepository; 
    }

    @GetMapping("/artists/")
    public Collection<Artist> retrieveArtists(){
        return (Collection<Artist>) artistRepository.findAll();
    }

    @GetMapping("/artists/{id}/")
    public Artist retrieveSingleArtist(@PathVariable Long id) {
        return artistRepository.findById(id).get();
    }
}
