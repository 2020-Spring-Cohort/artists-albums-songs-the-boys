package org.wcci.apimastery;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class AlbumControllerTest {

    private AlbumRepository albumRepo;
    private AlbumController underTest;
    private Artist testArtist;
    private Album testAlbum;

    @BeforeEach
    void setUp() {
        albumRepo = mock(AlbumRepository.class);
        underTest = new AlbumController(albumRepo);
        testArtist = new Artist("Drake");
        testAlbum = new Album("TestName", testArtist);
        when(albumRepo.findAll()).thenReturn(Collections.singletonList(testAlbum));
    }

    @Test
    public void retrieveAlbumsReturnsListOfAlbums() {
        underTest.retrieveAlbums();
        verify(albumRepo).findAll();


    }

    @Test

    public void retrieveAlbumsReturnsListOfAlbumsContainingMockAlbums() {
        Collection<Album> result= underTest.retrieveAlbums();
        assertThat(result).contains(testAlbum);

    }




}
