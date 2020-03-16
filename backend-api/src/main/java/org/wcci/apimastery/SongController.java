package org.wcci.apimastery;

import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class SongController {

    private SongRepository songRepo;

    SongController(){}

    SongController(SongRepository songRepo){
        this.songRepo = songRepo;
    }

    public Collection<Song> retrieveSongs() {
        return (Collection<Song>) songRepo.findAll();
    }
}
