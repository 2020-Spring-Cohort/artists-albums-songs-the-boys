package org.wcci.apimastery;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.wcci.apimastery.Controllers.SongController;
import org.wcci.apimastery.Entities.Album;
import org.wcci.apimastery.Entities.Artist;
import org.wcci.apimastery.Entities.Song;
import org.wcci.apimastery.Storage.Repositories.SongRepository;
import org.wcci.apimastery.Storage.SongStorage;
import static org.hamcrest.Matchers.is;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import java.util.Collection;
import java.util.Collections;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

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
        testSong = new Song("Test Song", "3:00", testAlbum);
        when(songRepo.findAll()).thenReturn(Collections.singletonList(testSong));
        mockMvc = MockMvcBuilders.standaloneSetup(underTest).build();
        songStorage = mock(SongStorage.class);
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
        mockMvc.perform(get("/songs/1/"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.title", is("Test Song")))
                .andExpect(jsonPath("$.duration", is("3:00")));


    }

//    @Test
//    public void addSongShouldAddNewSong() throws SongNotFoundException, Exception {
//        mockMvc.perform(post("/songs/"))
//
//        verify(songStorage).store(new Song("Test Song", "3:00", testArtist, testAlbum));
//
//    }

    @Test
    public void deleteSongWillAskRepoToDelete(){
        underTest.deleteSong(1L);
        verify(songRepo).deleteById(1L);
    }

    @Test
    public void underTestIsWiredForDeleteRequest() throws Exception{
        mockMvc.perform(delete("/songs/1/"))
                .andExpect(status().isOk());
        verify(songRepo).deleteById(1L);
    }

}
