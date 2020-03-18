package org.wcci.apimastery.Storage;


import org.wcci.apimastery.Entities.Song;
import org.wcci.apimastery.SongNotFoundException;

import java.util.Collection;

public interface SongStorage {
    Collection<Song> findAllSongs();

    void store( Song song);

    Song findSongByTitle(String songTitle) throws SongNotFoundException;
}
