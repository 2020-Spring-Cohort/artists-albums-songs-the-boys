package org.wcci.apimastery;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController

public class AlbumController {

    private AlbumRepository albumRepository;
    private Artist testArtist = new Artist("testName");
    private Album testAlbum = new Album("testName", testArtist);

    public AlbumController(AlbumRepository albumRepository) {
        this.albumRepository = albumRepository;
    }

    @RequestMapping("/albums")
    public Collection<Album> retrieveAlbums() {
        return (Collection<Album>) albumRepository.findAll();
    }

    @RequestMapping("/album")
    public java.util.Optional<Album> retrieveSingleAlbum(){
        return albumRepository.findById(testAlbum.getId());
    }

}

