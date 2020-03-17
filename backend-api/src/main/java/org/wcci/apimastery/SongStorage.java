package org.wcci.apimastery;


import java.text.CollationElementIterator;
import java.util.Collection;

public interface SongStorage {
    Collection<Song> findAllSongs();

    void store( Song song);

    Song findSongByTitle(String songTitle) throws SongNotFoundException;
}
