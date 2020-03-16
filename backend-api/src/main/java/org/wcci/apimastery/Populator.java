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

        Song lowSelfOpinion = new Song ("Low Self Opinion", "5:18", rollinsBand, theEndOfSilence);
        songRepository.save(lowSelfOpinion);
        Song grip = new Song ("Grip", "4:50", rollinsBand, theEndOfSilence);
        songRepository.save(grip);
        Song tearing = new Song("Tearing", "4:58", rollinsBand, theEndOfSilence);
        songRepository.save(tearing);
        Song youDidntNeed = new Song ("You Didn't Need", "5:30", rollinsBand, theEndOfSilence);
        songRepository.save(youDidntNeed);
        Song almostReal = new Song ("Almost Real", "8:03", rollinsBand, theEndOfSilence);
        songRepository.save(almostReal);
        Song obscene = new Song ("Obscene", "8:50", rollinsBand, theEndOfSilence);
        songRepository.save(obscene);
        Song whatDoYouDo = new Song ("What Do You Do", "7:22", rollinsBand, theEndOfSilence);
        songRepository.save(whatDoYouDo);
        Song bluesJam = new Song("Blues Jam", "11:46", rollinsBand, theEndOfSilence);
        songRepository.save(bluesJam);
        Song anotherLife = new Song("Another Life", "4:39", rollinsBand, theEndOfSilence);
        songRepository.save(anotherLife);
        Song justLikeYou = new Song("Just Like You", "9:30", rollinsBand, theEndOfSilence);
        songRepository.save(justLikeYou);

        Song tooMuchRock = new Song("Too Much Rock and Roll", "3:50", rollinsBand, aNicerShadeOfRed);
        songRepository.save(tooMuchRock);
        Song marcus = new Song("Marcus Has the Evil in Him", "4:01", rollinsBand, aNicerShadeOfRed);
        songRepository.save(marcus);
        Song nowhere = new Song("Nowhere to Go but Inside", "3:04", rollinsBand, aNicerShadeOfRed);
        songRepository.save(nowhere);
        Song tenX = new Song("10X", "3:04", rollinsBand, aNicerShadeOfRed);
        songRepository.save(tenX);
        Song always = new Song("Always the Same", "2:57", rollinsBand, aNicerShadeOfRed);
        songRepository.save(always);
        Song soul = new Song("Soul Implant", "1:56", rollinsBand, aNicerShadeOfRed);
        songRepository.save(soul);
        
    }
}
