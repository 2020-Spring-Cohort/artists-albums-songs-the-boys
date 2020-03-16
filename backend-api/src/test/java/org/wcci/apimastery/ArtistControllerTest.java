package org.wcci.apimastery;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;
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

    @Test
    public void retrieveArtistsReturnsListOfArtistsContainingMockArtist(){
        Collection<Artist> result = underTest.retrieveArtists();
        assertThat(result).contains(testArtist);
    }
}
