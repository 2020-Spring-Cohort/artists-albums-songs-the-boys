package org.wcci.apimastery.Storage;


import org.springframework.stereotype.Service;
import org.wcci.apimastery.Entities.Song;
import org.wcci.apimastery.SongNotFoundException;
import org.wcci.apimastery.Storage.Repositories.SongRepository;

import java.util.Collection;

@Service
public class SongStorageJpaImpl implements SongStorage{
    private final SongRepository songRepo;

    public SongStorageJpaImpl(SongRepository songRepo){
        this.songRepo = songRepo;
    }

    @Override
    public Collection<Song> findAllSongs(){
        return (Collection<Song>) songRepo.findAll();
    }

    @Override
    public void store(Song song){
        songRepo.save(song);
    }

    @Override
    public Song findSongByTitle(String songTitle) throws SongNotFoundException {
        Song retrievedSong;
            try{
                retrievedSong = songRepo.findByTitle(songTitle).get();
            }
            catch (Exception e){
                throw new SongNotFoundException(e.getMessage());
            }
            return retrievedSong;
    }
}
