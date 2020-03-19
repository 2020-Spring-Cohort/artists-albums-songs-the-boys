package org.wcci.apimastery.Controllers;


import org.springframework.web.bind.annotation.*;
import org.wcci.apimastery.Entities.Album;
import org.wcci.apimastery.Entities.Song;
import org.wcci.apimastery.Storage.Repositories.AlbumRepository;
import org.wcci.apimastery.Storage.Repositories.SongRepository;

import java.util.Collection;

@RestController

public class AlbumController {

    private AlbumRepository albumRepository;
    private SongRepository songRepository;

    public AlbumController(AlbumRepository albumRepository, SongRepository songRepository) {
        this.albumRepository = albumRepository;
        this.songRepository = songRepository;
    }

    @GetMapping("/albums/")
    public Collection<Album> retrieveAlbums() {
        return (Collection<Album>) albumRepository.findAll();
    }

    @GetMapping("/albums/{id}")
    public Album retrieveSingleAlbum(@PathVariable Long id){
        return albumRepository.findById(id).get();
    }

    @PostMapping("/albums/")
    public Album addAlbum(@RequestBody Album albumToAdd) {
        return albumRepository.save(albumToAdd);
    }

    @DeleteMapping("/albums/{id}/")
    public void deleteAlbum(@PathVariable Long id) {
        Album albumToRemove = albumRepository.findById(id).get();
        for (Song songToRemove : albumToRemove.getSongs()){
            songRepository.delete(songToRemove);
        }
        albumRepository.deleteById(id);
    }
}

