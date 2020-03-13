package org.wcci.apimastery;


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

    @Test
    public void artistShouldHaveAlbums(){
        Artist testArtist = new Artist();
       artistRepo.save(testArtist);
       Album testAlbum1 = new Album("testName1", testArtist);
        Album testAlbum2 = new Album("test2Name",testArtist);
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
        Artist testArtist= new Artist("testArtist");
        artistRepo.save(testArtist);
        Album testAlbum= new Album("testAlbum",testArtist);
        albumRepo.save(testAlbum);
        Song testSong1= new Song("testSong1", testArtist, testAlbum);
        Song testSong2= new Song("testSong2",testArtist,testAlbum);
        songRepo.save(testSong1);
        songRepo.save(testSong2);
        entityManager.flush();
        entityManager.clear();
        Album retrievedAlbum=albumRepo.findById(testAlbum.getId()).get();
        Song retrievedSong=songRepo.findById(testSong1.getId()).get();
        Song retrievedSong2=songRepo.findById(testSong2.getId()).get();
        assertThat(retrievedAlbum.getSongs()).contains(retrievedSong, retrievedSong2);




    }


}
