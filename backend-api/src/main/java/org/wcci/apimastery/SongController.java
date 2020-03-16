package org.wcci.apimastery;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class SongController {

    private SongRepository songRepo;

    SongController(SongRepository songRepo){
        this.songRepo = songRepo;
    }

    @RequestMapping("/songs")
    public Collection<Song> retrieveSongs() {
        return (Collection<Song>) songRepo.findAll();
    }
}
