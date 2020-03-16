package org.wcci.apimastery;

import java.util.Collection;

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
