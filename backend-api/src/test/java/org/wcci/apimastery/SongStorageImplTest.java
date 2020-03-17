package org.wcci.apimastery;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class SongStorageImplTest {

    private SongRepository songRepo;
    private SongStorageJpaImpl underTest;
    private Song testSong;
    private Artist testArtist;
    private Album testAlbum;


    @BeforeEach
    void setUp() {
        songRepo = mock(SongRepository.class);
        underTest = new SongStorageJpaImpl(songRepo);
        testArtist = new Artist("Test Artist");
        testAlbum = new Album("Test Album", testArtist);
        testSong = new Song("Test Song", "3:00", testArtist, testAlbum);

    }

    @Test
    public void shouldBeAbleToFindAllSongs() {
        when(songRepo.findAll()).thenReturn(Collections.singletonList(testSong));
        underTest.store(testSong);
        verify(songRepo).save(testSong);
        assertThat(underTest.findAllSongs()).contains(testSong);
    }
}

