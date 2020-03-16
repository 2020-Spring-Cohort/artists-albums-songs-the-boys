package org.wcci.apimastery;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class ArtistController {
    private ArtistRepository artistRepository;

    public ArtistController(ArtistRepository artistRepository){
        this.artistRepository = artistRepository;
    }
    @RequestMapping("/artists")
    public Collection<Artist> retrieveArtists(){
        return (Collection<Artist>) artistRepository.findAll();
    }
}
