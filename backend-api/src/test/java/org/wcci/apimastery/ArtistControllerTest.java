package org.wcci.apimastery;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.wcci.apimastery.Controllers.ArtistController;
import org.wcci.apimastery.Entities.Artist;
import org.wcci.apimastery.Storage.Repositories.AlbumRepository;
import org.wcci.apimastery.Storage.Repositories.ArtistRepository;
import org.wcci.apimastery.Storage.Repositories.SongRepository;

import java.util.Collection;
import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class ArtistControllerTest {
    private ArtistRepository artistRepository;
    private ArtistController underTest;
    private Artist testArtist;
    private AlbumRepository albumRepository;
    private SongRepository songRepository;

    @BeforeEach
    void setUp(){
        artistRepository = mock(ArtistRepository.class);
        underTest = new ArtistController(artistRepository, albumRepository, songRepository);
        testArtist = new Artist("testArtist");
        when(artistRepository.findAll()).thenReturn(Collections.singletonList(testArtist));
        when(artistRepository.findById(2L)).thenReturn(java.util.Optional.ofNullable(testArtist));
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

    @Test
    public void underTestIsWiredCorrectlyWithAnnotations() throws Exception {
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(underTest).build();
        mockMvc.perform(get("/artists/"))
                .andExpect(status().isOk());
    }

    @Test
    public void retrieveSingleArtistReturnsASingleArtist(){
        Artist result = underTest.retrieveSingleArtist(2L);
        verify(artistRepository).findById(2L);
        assertThat(result).isEqualTo(testArtist);
    }

}
