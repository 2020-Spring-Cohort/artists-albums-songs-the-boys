package org.wcci.apimastery;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import java.util.Collection;
import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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

    @Test

    public void controllerIsWiredCorrectly() throws Exception
      {
          MockMvc mockMvc = MockMvcBuilders.standaloneSetup(underTest).build();
          mockMvc.perform(get("/albums"))
          .andExpect(status().isOk());
    }

    @Test
    public void retrieveAlbumReturnsSingleAlbum(){
        underTest.retrieveSingleAlbum();
        verify(albumRepo).findById(testAlbum.getId());
    }
    
}
