package org.wcci.apimastery.Controllers;

import org.springframework.web.bind.annotation.*;
import org.wcci.apimastery.Entities.Song;
import org.wcci.apimastery.Storage.Repositories.SongRepository;

import java.util.Collection;

@RestController
public class SongController {

    private SongRepository songRepo;

    public SongController(SongRepository songRepo) {
        this.songRepo = songRepo;
    }

    @GetMapping("/songs/")
    public Collection<Song> retrieveSongs() {
        return (Collection<Song>) songRepo.findAll();
    }

    @GetMapping("/songs/{id}/")
    public Song displaySingleSong(@PathVariable Long id) {
        Song retrieveSong = songRepo.findById(id).get();
        return retrieveSong;
    }

    @PostMapping("/songs")
    public Song addSong(@RequestBody Song songToAdd){
        return songRepo.save(songToAdd);
    }


    @DeleteMapping("/songs/{id}/")
    public void deleteSong(@PathVariable Long id) {
        songRepo.deleteById(id);
    }
}






