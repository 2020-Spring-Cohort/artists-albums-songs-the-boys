package org.wcci.apimastery;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.wcci.apimastery.Entities.Album;
import org.wcci.apimastery.Entities.Artist;
import org.wcci.apimastery.Entities.Song;
import org.wcci.apimastery.Storage.Repositories.SongRepository;
import org.wcci.apimastery.Storage.SongStorage;
import org.wcci.apimastery.Storage.SongStorageJpaImpl;

import java.util.Collections;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class SongStorageImplTest {

    private SongRepository songRepo;
    private SongStorageJpaImpl underTest;
    private Song testSong1;
    private Song testSong2;
    private Artist testArtist;
    private Album testAlbum;


    @BeforeEach
    void setUp() {
        songRepo = mock(SongRepository.class);
        underTest = new SongStorageJpaImpl(songRepo);
        testArtist = new Artist("Test Artist");
        testAlbum = new Album("Test Album", testArtist);
        testSong1 = new Song("Test Song", "3:00", testAlbum);
        testSong2 = new Song("Test Song 2", "3:30", testAlbum);


    }

    @Test
    public void shouldBeAbleToFindAllSongs() {
        when(songRepo.findAll()).thenReturn(Collections.singletonList(testSong1));
        underTest.store(testSong1);
        verify(songRepo).save(testSong1);
        assertThat(underTest.findAllSongs()).contains(testSong1);
    }

    @Test
    public void shouldBeAbleToFindSongById() throws SongNotFoundException {
        SongStorage underTest = new SongStorageJpaImpl(songRepo);
        underTest.store(testSong1);
        underTest.store(testSong2);
        Optional<Song> testSong1Optional = Optional.of(testSong1);
        when(songRepo.findById(1L)).thenReturn(testSong1Optional);

        Optional<Song> testSong2Optional = Optional.of(testSong2);
        when(songRepo.findById(2L)).thenReturn(testSong2Optional);
        Song retrievedSong1 = underTest.findSongById(1L);
        Song retrievedSong2 = underTest.findSongById(2L);

        assertThat(retrievedSong1).isEqualTo(testSong1);
        assertThat(retrievedSong2).isEqualTo(testSong2);



    }
}

