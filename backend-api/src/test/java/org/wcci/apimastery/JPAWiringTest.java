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
       Artist retrieveArtist = artistRepo.findById(testArtist.getId()).get();
       Album retrieveAlbum1 = albumRepo.findById(testAlbum1.getId()).get();
        Album retrieveAlbum2 = albumRepo.findById(testAlbum2.getId()).get();
        assertThat(retrieveArtist.getAlbums()).contains(retrieveAlbum1, retrieveAlbum2);

    }


}
