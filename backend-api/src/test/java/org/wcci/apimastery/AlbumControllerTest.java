package org.wcci.apimastery;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.wcci.apimastery.Controllers.AlbumController;
import org.wcci.apimastery.Entities.Album;
import org.wcci.apimastery.Entities.Artist;
import org.wcci.apimastery.Storage.Repositories.AlbumRepository;
import org.wcci.apimastery.Storage.Repositories.SongRepository;

import java.util.Collection;
import java.util.Collections;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


public class AlbumControllerTest {

    private AlbumRepository albumRepo;
    private SongRepository songRepo;
    private AlbumController underTest;
    private Artist testArtist;
    private Album testAlbum;
    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        albumRepo = mock(AlbumRepository.class);
        underTest = new AlbumController(albumRepo, songRepo);
        testArtist = new Artist("Drake");
        testAlbum = new Album("TestName", testArtist);
        when(albumRepo.findAll()).thenReturn(Collections.singletonList(testAlbum));
        when(albumRepo.findById(1L)).thenReturn(Optional.ofNullable(testAlbum));
        mockMvc = MockMvcBuilders.standaloneSetup(underTest).build();
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

    @Test

    public void controllerIsWiredCorrectly() throws Exception {
          mockMvc.perform(get("/albums"))
          .andExpect(status().isOk());
    }

    @Test
    public void underTestIsWiredCorrectlyForSingleAlbum() throws Exception {
        when(albumRepo.findById(1L)).thenReturn(Optional.of(testAlbum));
        mockMvc.perform(get("/albums/1/"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.name", is("TestName")));
    }

    @Test
    public void shouldBeAbleToAddAlbum() {
       underTest.addAlbum(testAlbum);
       Collection<Album> result= underTest.retrieveAlbums();
       assertThat(result).contains(testAlbum);
    }

    @Test
    public void shouldBeAbleToDeleteAlbum(){
        underTest.deleteAlbum(1L);
        verify(albumRepo).deleteById(1L);
    }
}
