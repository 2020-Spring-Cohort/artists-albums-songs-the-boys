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
        Song fun = new Song("Ain't It Fun", "3:43", rollinsBand, aNicerShadeOfRed);
        songRepository.save(fun);
        Song lost = new Song("You Lost Me", "5:47", rollinsBand, aNicerShadeOfRed);
        songRepository.save(lost);
        Song stone = new Song("Stone Washed Clean", "4:18", rollinsBand, aNicerShadeOfRed);
        songRepository.save(stone);
        Song lifeDenied = new Song("A Life Denied", "3:25", rollinsBand, aNicerShadeOfRed);
        songRepository.save(lifeDenied);
        Song number = new Song("Your Number IS One (Long Version)", "4:37", rollinsBand, aNicerShadeOfRed);
        songRepository.save(number);
        Song drag = new Song("Such a Drag", "12:55", rollinsBand, aNicerShadeOfRed);
        songRepository.save(drag);

        Song danish = new Song("Danish Pastry Lyrics", "3:32", porridgeRadio, ricePasta);
        songRepository.save(danish);
        Song lemonade = new Song("Lemonade", "2:41", porridgeRadio, ricePasta);
        songRepository.save(lemonade);
        Song barks = new Song("Barks Like A Dog", "5:26", porridgeRadio, ricePasta);
        songRepository.save(barks);
        Song cow = new Song("Walking The Cow (Daniel Johnston cover)", "2:35", porridgeRadio, ricePasta);
        songRepository.save(cow);
        Song hearMe = new Song("Can U Hear Me Now", "7:33", porridgeRadio, ricePasta);
        songRepository.save(hearMe);
        Song sorry = new Song("Sorry", "5:31", porridgeRadio, ricePasta);
        songRepository.save(sorry);
        Song worms = new Song("Worms", "1:51", porridgeRadio, ricePasta);
        songRepository.save(worms);
        Song wasLike = new Song("And I Was Like", "1:38", porridgeRadio, ricePasta);
        songRepository.save(wasLike);
        Song eugh = new Song("Eugh", "4:38", porridgeRadio, ricePasta);
        songRepository.save(eugh);

        Song sweet = new Song("Sweet", "3:42", porridgeRadio, everyBad);
        songRepository.save(sweet);
        Song askMe = new Song("Don't Ask Me Twice", "3:21", porridgeRadio, everyBad);
        songRepository.save(askMe);
        Song giveTake = new Song("Give/Take", "3:53", porridgeRadio, everyBad);
        songRepository.save(giveTake);
        Song lilac = new Song("Lilac", "5:27", porridgeRadio, everyBad);
        songRepository.save(lilac);
        Song circling = new Song("Circling", "3:20", porridgeRadio, everyBad);
        songRepository.save(circling);

        Song tuscan = new Song("Tuscan Leather", "6:06", drake, nothingSame);
        songRepository.save(tuscan);
        Song furthest = new Song("Furthest Things", "4:27", drake, nothingSame);
        songRepository.save(furthest);
        Song bottom = new Song("Started From the Bottom", "2:53", drake, nothingSame);
        songRepository.save(bottom);
        Song wutang = new Song("Wu-Tang Forever", "3:37", drake, nothingSame);
        songRepository.save(wutang);
        Song ownIt = new Song("Own It", "4:11", drake, nothingSame);
        songRepository.save(ownIt);
        Song worst = new Song("Worst Behavior", "4:30", drake, nothingSame);
        songRepository.save(worst);
        Song time = new Song("From Time feat. Jhene Aiko", "5:22", drake, nothingSame);
        songRepository.save(time);
        Song holdOn = new Song("Hold On, We're Going Home feat. Majid Jordan", "3:51", drake, nothingSame);
        songRepository.save(holdOn);
        Song connect = new Song("Connect", "4:56", drake, nothingSame);
        songRepository.save(connect);
        Song language = new Song("The Language", "3:44", drake, nothingSame);
        songRepository.save(language);
        Song city = new Song("305 to My City feat. Detail", "4:15", drake, nothingSame);
        songRepository.save(city);
        Song tooMuch = new Song("Too Much", "4:21", drake, nothingSame);
        songRepository.save(tooMuch);
        Song pound = new Song("Pound Cake/Paris Morton Music feat. Jay-Z", "27:13", drake, nothingSame);
        songRepository.save(pound);

        Song family = new Song("Keep the Family Close", "5:28", drake, views);
        songRepository.save(family);
    }
}
