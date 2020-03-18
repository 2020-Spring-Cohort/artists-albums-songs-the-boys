package org.wcci.apimastery;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.wcci.apimastery.Controllers.SongController;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import java.util.Collection;
import java.util.Collections;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class SongControllerTest {

    private SongRepository songRepo;
    private SongController underTest;
    private Song testSong;
    private Artist testArtist;
    private Album testAlbum;
    private SongStorage songStorage;
    private MockMvc mockMvc;

    @BeforeEach
    void setUp(){
        songRepo = mock(SongRepository.class);
        underTest = new SongController(songRepo);
        testArtist = new Artist("Test Artist");
        testAlbum = new Album("Test Album", testArtist);
        testSong = new Song("Test Song", testArtist, testAlbum);
        when(songRepo.findAll()).thenReturn(Collections.singletonList(testSong));
        mockMvc = MockMvcBuilders.standaloneSetup(underTest).build();

    }

    @Test
    public void retrieveSongsReturnsListOfSongsFromMockRepo(){
        underTest.retrieveSongs();
        verify(songRepo).findAll();
    }

    @Test
    public void retrieveSongsReturnsListOfSongsContainingMockSong(){
        Collection<Song> result = underTest.retrieveSongs();
        assertThat(result).contains(testSong);
    }
    @Test
    public void shouldGoToIndividualEndPoint() throws Exception, SongNotFoundException {
        when(songRepo.findById(1L)).thenReturn(Optional.of(testSong));
        mockMvc.perform(get("/songs/1"))
                .andExpect(status().isOk());


    }
//
//    @Test
//    public void shouldGoToIndividualSongEndPoint() throws Exception{
//        when(songRepo.findByTitle("Test Song"));
//    }


}
