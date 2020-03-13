package org.wcci.apimastery;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;


@DataJpaTest
public class JPAWiringTest {

    @Autowired
    private ArtistRepository artistRepo;


    @Test
    public void artistShouldHaveAlbums(){
        Artist testArtist = new Artist();
       artistRepo.save(testArtist);

    }

}
