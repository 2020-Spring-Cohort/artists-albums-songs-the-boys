package org.wcci.apimastery;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.mockito.Mockito.*;

public class ArtistControllerTest {
    private ArtistRepository artistRepository;
    private ArtistController underTest;
    private Artist testArtist;

    @BeforeEach
    void setUp(){
        artistRepository = mock(ArtistRepository.class);
        underTest = new ArtistController(artistRepository);
        testArtist = new Artist("testArtist");
        when(artistRepository.findAll()).thenReturn(Collections.singletonList(testArtist));
    }

    @Test
    public void retrieveArtistsReturnsListOfArtistsFromMockRepo(){
        underTest.retrieveArtists();
        verify(artistRepository).findAll();
    }
}
