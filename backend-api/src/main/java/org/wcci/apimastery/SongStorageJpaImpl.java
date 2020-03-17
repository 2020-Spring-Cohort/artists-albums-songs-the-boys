package org.wcci.apimastery;


import org.springframework.stereotype.Service;

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
