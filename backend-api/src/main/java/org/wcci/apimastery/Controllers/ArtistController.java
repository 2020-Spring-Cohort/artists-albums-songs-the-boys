package org.wcci.apimastery.Controllers;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.wcci.apimastery.Entities.Album;
import org.wcci.apimastery.Entities.Artist;
import org.wcci.apimastery.Entities.Song;
import org.wcci.apimastery.Storage.Repositories.AlbumRepository;
import org.wcci.apimastery.Storage.Repositories.ArtistRepository;
import org.wcci.apimastery.Storage.Repositories.SongRepository;

import java.util.Collection;

@RestController
public class ArtistController {
    private ArtistRepository artistRepository;
    private AlbumRepository albumRepository;
    private SongRepository songRepository;

    public ArtistController(ArtistRepository artistRepository,AlbumRepository albumRepository, SongRepository songRepository) {
        this.artistRepository = artistRepository;
        this.albumRepository= albumRepository;
        this.songRepository= songRepository;
    }

    @GetMapping("/artists/")
    public Collection<Artist> retrieveArtists() {
        return (Collection<Artist>) artistRepository.findAll();
    }

    @GetMapping("/artists/{id}/")
    public Artist retrieveSingleArtist(@PathVariable Long id) {
        return artistRepository.findById(id).get();
    }


    @DeleteMapping("/artists/{id}/")
    public void deleteArtist(@PathVariable Long id) {
        Artist artistToRemove= artistRepository.findById(id).get();

        for (Album albumToRemove: artistToRemove.getAlbums()) {
            for(Song songToRemove: albumToRemove.getSongs()) {
                songRepository.delete(songToRemove);
            }

                albumRepository.delete(albumToRemove);
        }
        artistRepository.deleteById(id);
    }



}




