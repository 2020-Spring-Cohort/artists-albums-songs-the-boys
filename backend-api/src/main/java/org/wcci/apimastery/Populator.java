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
        Album theEndOfSilence = new Album("The End Of Silence", rollinsBand);
        albumRepository.save(theEndOfSilence);
        Album aNicerShadeOfRed = new Album("A Nicer Shade Of Red", rollinsBand);
        albumRepository.save(aNicerShadeOfRed);
        Album ricePasta = new Album("Rice, Pasta, and Other Fillers", porridgeRadio);
        albumRepository.save(ricePasta);
        Album everyBad = new Album("Every Bad", porridgeRadio);
        albumRepository.save(everyBad);
        Album nothingSame = new Album("Nothing Was The Same", drake);
        albumRepository.save(nothingSame);
        Album views = new Album("Views", drake);
        albumRepository.save(views);
        Album closerToSun = new Album("Closer To The Sun", slightlyStoopid);
        albumRepository.save(closerToSun);
        Album everythingNeed = new Album("Everything You Need", slightlyStoopid);
        albumRepository.save(everythingNeed);
        Album ageAdz = new Album("The Age Of Adz", sufjanStevens);
        albumRepository.save(ageAdz);
        Album carrieLowell = new Album("Carrie & Lowell", sufjanStevens);
        albumRepository.save(carrieLowell);
        Album badHair = new Album("Bad Hair Day", weirdAlYankovic);
        albumRepository.save(badHair);
        Album runningScissors = new Album("Running With Scissors", weirdAlYankovic);
        albumRepository.save(runningScissors);

    }
}
