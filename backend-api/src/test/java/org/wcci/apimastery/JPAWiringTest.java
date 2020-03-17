package org.wcci.apimastery;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import javax.persistence.Entity;

import static org.assertj.core.api.Assertions.assertThat;


@DataJpaTest
public class JPAWiringTest {
    @Autowired
    private TestEntityManager entityManager;
    @Autowired
    private ArtistRepository artistRepo;
    @Autowired
    private AlbumRepository albumRepo;
    @Autowired
    private SongRepository songRepo;
    private Artist testArtist;
    private Album testAlbum1;
    private Album testAlbum2;
    private Song testSong1;
    private Song testSong2;


    @BeforeEach
    void setUp() {
        testArtist = new Artist("testArtist");
        testAlbum1 = new Album("testName1", testArtist);
        testAlbum2 = new Album("testName2", testArtist);
        testSong1 = new Song("testSong1", "2:00", testArtist, testAlbum1);
        testSong2 = new Song("testSong2", "3:00", testArtist, testAlbum1);
    }

    @Test
    public void artistShouldHaveAlbums(){
       artistRepo.save(testArtist);
       albumRepo.save(testAlbum1);
       albumRepo.save(testAlbum2);
       entityManager.flush();
       entityManager.clear();
       Artist retrievedArtist = artistRepo.findById(testArtist.getId()).get();
       Album retrievedAlbum1 = albumRepo.findById(testAlbum1.getId()).get();
       Album retrievedAlbum2 = albumRepo.findById(testAlbum2.getId()).get();
       assertThat(retrievedArtist.getAlbums()).contains(retrievedAlbum1, retrievedAlbum2);

    }

    @Test
    public void albumsShouldHaveSongs() {
        artistRepo.save(testArtist);
        albumRepo.save(testAlbum1);
        songRepo.save(testSong1);
        songRepo.save(testSong2);
        entityManager.flush();
        entityManager.clear();
        Album retrievedAlbum=albumRepo.findById(testAlbum1.getId()).get();
        Song retrievedSong=songRepo.findById(testSong1.getId()).get();
        Song retrievedSong2=songRepo.findById(testSong2.getId()).get();
        assertThat(retrievedAlbum.getSongs()).contains(retrievedSong, retrievedSong2);
    }

    @Test
    public void artistsShouldHaveSongs() {
        artistRepo.save(testArtist);
        albumRepo.save(testAlbum1);
        songRepo.save(testSong1);
        songRepo.save(testSong2);
        entityManager.flush();
        entityManager.clear();
        Artist retrievedArtist = artistRepo.findById(testArtist.getId()).get();
        Song retrievedSong = songRepo.findById(testSong1.getId()).get();
        Song retrievedSong2 = songRepo.findById(testSong2.getId()).get();
        assertThat(retrievedArtist.getSongs()).contains(retrievedSong, retrievedSong2);
    }
}
