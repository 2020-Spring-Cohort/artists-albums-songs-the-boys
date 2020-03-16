package org.wcci.apimastery;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Populator implements CommandLineRunner {

   @Autowired
   private ArtistRepository artistRepository;
   @Autowired
   private AlbumRepository albumRepository;
   @Autowired
   private SongRepository songRepository;


    @Override
    public void run(String... args) throws Exception {
        Artist rollinsBand = new Artist("Rollins Band");
        artistRepository.save(rollinsBand);
        Artist porridgeRadio = new Artist("Porridge Radio");
        artistRepository.save(porridgeRadio);
        Artist drake = new Artist("Drake");
        artistRepository.save(drake);
        Artist slightlyStoopid = new Artist("Slightly Stoopid");
        artistRepository.save(slightlyStoopid);
        Artist sufjanStevens = new Artist("Sufjan Stevens");
        artistRepository.save(sufjanStevens);
        Artist weirdAlYankovic = new Artist("Weird Al Yankovic");
        artistRepository.save(weirdAlYankovic);
    }
}
