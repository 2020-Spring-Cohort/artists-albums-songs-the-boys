package org.wcci.apimastery.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.wcci.apimastery.Song;
import org.wcci.apimastery.SongRepository;

import java.util.Collection;

@RestController
public class SongController {

    private SongRepository songRepo;

    SongController(SongRepository songRepo){
        this.songRepo = songRepo;
    }

    @GetMapping("/songs")
    public Collection<Song> retrieveSongs() {
        return (Collection<Song>) songRepo.findAll();
    }
    @GetMapping("songs/{id}")
    public Song displaySingleSong(@PathVariable Long id){
        Song retrieveSong = songRepo.findById(id).get();
            return retrieveSong;
        }

    }






