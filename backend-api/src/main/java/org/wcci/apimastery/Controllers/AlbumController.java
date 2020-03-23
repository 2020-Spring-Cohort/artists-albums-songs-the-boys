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

    @PatchMapping("/albums/{id}/songs/")
    public Album updateAlbum(@PathVariable Long id, @RequestBody Song requestBodySong){
        Album albumToUpdate = albumRepository.findById(id).get();
        Song songToAdd = new Song(requestBodySong.getTitle(), requestBodySong.getDuration(), albumToUpdate);
        songRepository.save(songToAdd);
        return albumRepository.save(albumToUpdate);
    }

    @PatchMapping("/albums/{id}/")
    public void addCommentToAlbum(@PathVariable Long id, @RequestBody String commentToAdd) {
        Album albumToUpdate = albumRepository.findById(id).get();
        albumToUpdate.addComment(commentToAdd);
    }
}

